package com.javasm.permission.dao;

import com.javasm.permission.entity.Role;

import java.sql.SQLException;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:55
 * @description
 */
public interface RoleDao {
    int insertRole(Role role) throws SQLException;
    int insertRoleAndPermission(int rid,String[] pid);
}
