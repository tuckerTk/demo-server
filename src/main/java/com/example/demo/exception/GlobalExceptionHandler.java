package com.example.demo.exception;

import com.example.demo.util.RestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public RestResponse myException(HttpServletRequest request, HttpServletResponse response, MyException ex) {
        RestResponse result = new RestResponse();
        result.setMessage(ex.getMsg());
        result.setSuccess(false);
        return result;
    }
}
