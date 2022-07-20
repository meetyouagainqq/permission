package com.javasm.permission.dao;

import com.javasm.permission.entity.Permission;

import java.util.List;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 20:19
 * @description
 */
public interface PermissionDao {
    public List<Permission> findAllPermissions();
}
