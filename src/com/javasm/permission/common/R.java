package com.javasm.permission.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sunshine
 * @version 1.0
 * @date 2022年07月20日 19:44
 * @description
 */
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> R<T> success() {
        return new R<>(StatusEnum.SUCCESS.getStatus(), StatusEnum.SUCCESS.getMsg());
    }

    public static <T> R<T> success(T data) {
        return new R<>(StatusEnum.SUCCESS.getStatus(), StatusEnum.SUCCESS.getMsg(), data);
    }

    public static <T> R<T> error() {
        return new R<>(StatusEnum.ERROR.getStatus(), StatusEnum.ERROR.getMsg());
    }
}
