package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class PageParams implements Serializable {

    private static final long serialVersionUID = 1934918991366524922L;
    //页数
    @Min(value = 1,message = "页数从1开始")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNum;
    //每页显示数量
    @Min(value = 1,message = "每页至少显示一条")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;
}
