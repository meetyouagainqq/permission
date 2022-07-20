package com.javasm.permission.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:50
 * @description
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {
    SUCCESS(200, "success"),
    ERROR(401, "error");
    private Integer status;
    private String msg;

}
