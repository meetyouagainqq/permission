package com.javasm.permission;

import com.javasm.permission.dao.PermissionDao;
import com.javasm.permission.dao.RoleDao;
import com.javasm.permission.dao.impl.PermissionDaoImpl;
import com.javasm.permission.dao.impl.RoleDaoImpl;
import com.javasm.permission.entity.Permission;
import com.javasm.permission.entity.Role;
import com.javasm.permission.service.RoleService;
import com.javasm.permission.service.impl.RoleServiceImpl;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:46
 * @description
 */
public class Test {
    //        public static void main(String[] args) throws SQLException {
//        Role role = new Role();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入用户名:");
//        String name = scanner.next();
//        System.out.println("请输入用户状态:");
//        int status = scanner.nextInt();
//        System.out.println("请输入用户描述:");
//        String desc=scanner.next();
//        RoleDao roleDao = new RoleDaoImpl();
//        role.setRoleName(name);
//        role.setRoleStatus(status);
//        role.setRoleDesc(desc);
//        int result = roleDao.insertRole(role);
//        System.out.println(result);
//    }
//    public static void main(String[] args) {
//        PermissionDao permissionDao = new PermissionDaoImpl();
//        List<Permission> permissionList = permissionDao.findAllPermissions();
//        permissionList.forEach(System.out::println);
//    }
    public static void main(String[] args) throws SQLException {
        Role role = new Role();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = scanner.next();
        System.out.println("请输入用户状态:");
        int status = scanner.nextInt();
        System.out.println("请输入用户描述:");
        String desc = scanner.next();
        role.setRoleName(name);
        role.setRoleStatus(status);
        role.setRoleDesc(desc);
        System.out.println("***************");
        System.out.println("请分配" + name + "权限功能");
        System.out.println("用户权限如下:");
        PermissionDao permissionDao = new PermissionDaoImpl();
        List<Permission> permissionList = permissionDao.findAllPermissions();
        String pathStr = "|-";
        permissionList.stream().filter(permission -> permission.getParentPerId().equals(0)).peek(parentPer ->
        {
            System.out.println(pathStr + parentPer.getId() + ":" + parentPer.getPerName());
            findChidPer(parentPer, permissionList, "|" + pathStr);
        }).count();
        //选择相应的权限
        System.out.println("请输入相应的权限:");
        String permissions = scanner.next();
        String[] strings = permissions.split(",");
        RoleService roleService = new RoleServiceImpl();
        System.out.println(roleService.insertRoleAndPer(role, strings));
    }

    private static void findChidPer(Permission parentPer, List<Permission> permissionList, String s) {
        permissionList.stream().filter(child -> child.getParentPerId().equals(parentPer.getId()))
                .peek(childPer -> {
                    System.out.println(s + childPer.getId() + ":" + childPer.getPerName());
                    findChidPer(childPer, permissionList, "|" + s);
                }).count();
    }
}
