package com.example.demo.advice;

import com.example.demo.common.CommonResult;
import com.example.demo.exception.ApiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(404);
        commonResult.setMsg("全局处理异常!");
        return commonResult;
    }

}
