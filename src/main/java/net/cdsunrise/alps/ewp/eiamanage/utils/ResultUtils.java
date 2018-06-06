package net.cdsunrise.alps.ewp.eiamanage.utils;

import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.viewObject.Result;

public class ResultUtils{

    /**
     * 成功返回
     * @return
     */
    public static Result success(){
        Result result = new Result(200,"success");
        return result;
    }

    /**
     * 成功返回且携带数据
     * @return
     */
    public static Result successWithData(Object data){
        Result result = new Result(200,"success",data);
        return result;
    }

    /**
     * 返回失败
     * @param exceptionEnums
     * @return
     */
    public static Result fail(ExceptionEnums exceptionEnums){
        Result result = new Result(exceptionEnums.getCode(),exceptionEnums.getMessage());
        return result;
    }
}
