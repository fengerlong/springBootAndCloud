package net.cdsunrise.alps.ewp.eiamanage.returnEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaterialsReturns implements Serializable {

    private static final long serialVersionUID = 6428345024686229252L;

    private String id;
    //文件名称
    private String name;
    //文件地址
    private String address;
    //文件类型
    private Integer type;
    //提交人Id
    private String submiterId;
    //提交人姓名
    private String submiterName;
}
