package com.javasm.permission.dao.impl;

import com.javasm.permission.dao.PermissionDao;
import com.javasm.permission.entity.Permission;
import com.javasm.permission.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 20:19
 * @description
 */
public class PermissionDaoImpl implements PermissionDao {

    @Override
    public List<Permission> findAllPermissions() {
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet resultSet = null;
        connection = DBUtil.getConnection();
        String sql = "select * from permission";
        List<Permission> permissionList = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                permissionList.add(getPermission(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, ps, resultSet);
        }
        return permissionList;
    }

    private Permission getPermission(ResultSet resultSet) {
        Permission permission = new Permission();
        try {
            permission.setId(resultSet.getInt("id"));
            permission.setParentPerId(resultSet.getInt("parent_per_id"));
            permission.setPerLogo(resultSet.getString("per_logo"));
            permission.setPerName(resultSet.getString("per_name"));
            permission.setPerUrl(resultSet.getString("per_url"));
            permission.setPerIdentity(resultSet.getString("per_identity"));
            permission.setPerStatus(resultSet.getInt("per_status"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return permission;
    }
}
