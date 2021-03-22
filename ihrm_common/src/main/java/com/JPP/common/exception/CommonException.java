package com.JPP.common.exception;

import com.JPP.common.entity.Result;
import com.JPP.common.entity.ResultCode;
import lombok.Getter;

/**
 * ）添加自定义的异常
 * */

@Getter
public class CommonException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private ResultCode code = ResultCode.SERVER_ERROR;

    public CommonException() {
    }

    public CommonException(ResultCode code) {
        super(ResultCode.FAIL.message());
        this.code = code;
    }
}
