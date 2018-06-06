package net.cdsunrise.alps.ewp.eiamanage.config;

import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.eiamanage.viewObject.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        if(e instanceof CustomException){
            e.printStackTrace();
            CustomException exception = (CustomException) e;
            return new Result(((CustomException) e).getCode(),((CustomException) e).getResultMsg());
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            //如果不是已知异常，返回系统异常
            e.printStackTrace();
            return new Result(ExceptionEnums.ACCESS_MODE);
        }else if(e instanceof HttpMessageNotReadableException){
            e.printStackTrace();
            return new Result(ExceptionEnums.PARAM_TYPE_ERROR);
        }else{
            //如果不是已知异常，返回系统异常
            e.printStackTrace();
            return new Result(ExceptionEnums.SYS_ERROR);
        }
    }
}
