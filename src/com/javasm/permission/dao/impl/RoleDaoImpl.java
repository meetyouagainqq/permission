package com.javasm.permission.dao.impl;

import com.javasm.permission.entity.Role;
import com.javasm.permission.dao.RoleDao;
import com.javasm.permission.util.DBUtil;

import java.sql.*;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:55
 * @description
 */
public class RoleDaoImpl implements RoleDao {
    PreparedStatement ps = null;
    int result;
    Connection connection = null;

    public RoleDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insertRole(Role role) throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "insert into role(role_name,role_status,role_desc) values (?,?,?)";
        ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, role.getRoleName());
        ps.setInt(2, role.getRoleStatus());
        ps.setString(3, role.getRoleDesc());
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            result = generatedKeys.getInt(1);
        }
        DBUtil.close(connection, ps);
        return result;
    }

    @Override
    public int insertRoleAndPermission(int rid, String[] pid) {
        connection = DBUtil.getConnection();
        StringBuilder builder = new StringBuilder();
        builder.append("insert into role_per(rid,pid) values");
        int length = pid.length;
        for (int i = 0; i < length; i++) {
            builder.append("(?,?)");
            if (i == length - 1) {
                break;
            }
            builder.append(",");
        }
        try {
            ps = connection.prepareStatement(builder.toString());
            int count = 0;
            for (int i = 0; i < length; i++) {
                ps.setInt(++count, rid);
                ps.setString(++count, pid[i]);
            }
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, ps);
        }
        return result;
    }
}
