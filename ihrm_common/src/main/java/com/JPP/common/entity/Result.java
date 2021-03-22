package com.JPP.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @data 2021.03.22
 * @author Administrator
 * 返回结果实体类,用于控制器类返回结果
 *
 * {
 *     success: 是否成功
 *     code : 返回码
 *     message : 返回信息
 *     data : {
 *         返回数据
 *     }
 * }
 *
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * 返回见过是否成功
     * */
    private boolean success;

    /**
     * 返回码
     * */
    private Integer code;

    /**
     * 返回信息
     * */
    private String message;

    /**
     * 返回数据
     * */
    private Object data;

    public Result(ResultCode resultCode) {
        this.code = resultCode.code;
        this.success = resultCode.success;
        this.message = resultCode.message;
    }

    public Result(ResultCode resultCode,Object data){
        this.code = resultCode.code;
        this.success = resultCode.success;
        this.message = resultCode.message;
        this.data = data;
    }

    public Result(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }
}
