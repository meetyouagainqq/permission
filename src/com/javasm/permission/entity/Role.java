package com.javasm.permission.entity;

import lombok.Data;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:35
 * @description
 */
@Data
public class Role {
    private Integer id;
    private String roleName;
    private Integer roleStatus;
    private String roleDesc;
}
