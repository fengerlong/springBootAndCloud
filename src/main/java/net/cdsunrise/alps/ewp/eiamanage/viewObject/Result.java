package net.cdsunrise.alps.ewp.eiamanage.viewObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;

@Data
public class Result<T> {
    //错误码
    private Integer code;
    //提示信息
    private String resultMsg;
    //返回数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result(Integer code, String resultMsg) {
        this.code = code;
        this.resultMsg = resultMsg;
    }

    public Result(Integer code, String resultMsg, T data) {
        this.code = code;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public Result(ExceptionEnums exceptionEnums){
        this.code = exceptionEnums.getCode();
        this.resultMsg = exceptionEnums.getMessage();
    }
}
