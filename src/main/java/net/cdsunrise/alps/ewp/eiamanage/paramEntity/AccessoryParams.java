package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class AccessoryParams implements Serializable {

    private static final long serialVersionUID = 6428345024686229252L;

    //文件名称
    @NotNull(message = "文件名称不能为空")
    @Size(min = 1,max = 255,message = "文件名称长度不符合规范")
    private String name;
    //文件地址
    @NotNull(message = "文件地址不能为空")
    @Size(min = 1,message = "文件地址长度不符合规范")
    private String address;
    //文件类型
    @Digits(integer = 1, fraction = 0,message = "文件类型不正确")
    private Integer type;
    //提交人Id
    @NotNull(message = "提交人ID不能为空")
    @Size(min = 1,max = 255,message = "提交人ID长度不符合规范")
    private String submiterId;
    //提交人姓名
    @NotNull(message = "提交人姓名不能为空")
    @Size(min = 1,max = 255,message = "提交人姓名长度不符合规范")
    private String submiterName;
}
