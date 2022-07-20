package com.javasm.permission.service;

import com.javasm.permission.common.R;
import com.javasm.permission.entity.Role;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 21:31
 * @description
 */
public interface RoleService {
    R<?> insertRoleAndPer(Role role,String[] pid);
}
