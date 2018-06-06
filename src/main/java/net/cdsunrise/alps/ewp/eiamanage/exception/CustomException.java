package net.cdsunrise.alps.ewp.eiamanage.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;

/**
 * 统一异常返回类
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CustomException extends RuntimeException {
    //错误码
    private Integer code;
    //提示信息
    private String resultMsg;

    public CustomException(Integer code, String resultMsg) {
        this.code = code;
        this.resultMsg = resultMsg;
    }
    public CustomException(ExceptionEnums exceptionEnums){
        this.code = exceptionEnums.getCode();
        this.resultMsg = exceptionEnums.getMessage();
    }
}
