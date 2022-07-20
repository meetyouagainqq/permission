package com.javasm.permission.service.impl;

import com.javasm.permission.common.R;
import com.javasm.permission.dao.RoleDao;
import com.javasm.permission.dao.impl.RoleDaoImpl;
import com.javasm.permission.entity.Role;
import com.javasm.permission.service.RoleService;
import com.javasm.permission.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 21:31
 * @description
 */
public class RoleServiceImpl implements RoleService {

    @Override
    public R<?> insertRoleAndPer(Role role, String[] pid) {
        Connection connection = DBUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            RoleDao roleDao = new RoleDaoImpl(connection);
            int roleId = roleDao.insertRole(role);
            roleDao.insertRoleAndPermission(roleId, pid);
            //手动提交事务
            connection.commit();
            return R.success();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            DBUtil.close(connection,null,null);
        }
        return R.error();
    }
}
