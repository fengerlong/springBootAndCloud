package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class ProcessInformationParams implements Serializable {

    private static final long serialVersionUID = 8164670811727894211L;

    private String id;
    @NotNull(message = "项目ID不能为空")
    @Size(min = 1,max = 255,message = "项目ID长度不符合规范")
    private String projectId;
    @NotNull(message = "项目名称不能为空")
    @Size(min = 1,max = 255,message = "项目名称ID长度不符合规范")
    private String projectName;
    @NotNull(message = "主题不能为空")
    @Size(min = 1,max = 255,message = "主题长度不符合规范")
    private String messageTheme;
    @NotNull(message = "类型ID不能为空")
    @Size(min = 1,max = 255,message = "类型ID长度不符合规范")
    private String typeId;
    @NotNull(message = "类型名称不能为空")
    @Size(min = 1,max = 255,message = "类型名称长度不符合规范")
    private String typeName;
    @NotNull(message = "状态ID不能为空")
    @Size(min = 1,max = 255,message = "状态ID长度不符合规范")
    private String stateId;
    @NotNull(message = "状态名称不能为空")
    @Size(min = 1,max = 255,message = "状态名称长度不符合规范")
    private String stateName;
    @NotNull(message = "内容不能为空")
    @Size(min = 1,max = 5000,message = "内容长度不符合规范")
    private String content;
    @NotNull(message = "提交人ID不能为空")
    @Size(min = 1,max = 255,message = "提交人ID长度不符合规范")
    private String submitterId;
    @NotNull(message = "提交人姓名不能为空")
    @Size(min = 1,max = 255,message = "提交人姓名长度不符合规范")
    private String submitterName;
    //附件信息
    private List<AccessoryParams> accessoryParamsList;
}
