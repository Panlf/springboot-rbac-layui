package com.plf.rbac.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public static<T> ResponseResult success(T data){
        return new ResponseResult(200,"处理成功",data);
    }

    public static<T> ResponseResult success(String message){
        return new ResponseResult(200,message,null);
    }

    public static<T> ResponseResult fail(String message){
        return new ResponseResult(500,message,null);
    }
}
