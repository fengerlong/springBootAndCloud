package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class PersonInformationParams implements Serializable {

    private static final long serialVersionUID = -1854205386370492048L;

    private String id;
    //人员ID
    @NotNull(message = "人员ID不能为空")
    @Size(min = 1,max = 255,message = "人员ID长度不符合规范")
    private String personId;
    //人员名称
    @NotNull(message = "人员姓名不能为空")
    @Size(min = 1,max = 255,message = "人员姓名长度不符合规范")
    private String personName;
    //项目Id
    @NotNull(message = "项目ID不能为空")
    @Size(min = 1,max = 255,message = "项目ID长度不符合规范")
    private String projectId;
    //项目名称
    @NotNull(message = "项目名称不能为空")
    @Size(min = 1,max = 255,message = "项目名称长度不符合规范")
    private String projectName;
    //组织ID
    @NotNull(message = "组织ID不能为空")
    @Size(min = 1,max = 255,message = "组织ID长度不符合规范")
    private String organizationId;
    //组织名称
    @NotNull(message = "组织姓名不能为空")
    @Size(min = 1,max = 255,message = "组织姓名长度不符合规范")
    private String organizationName;
    //角色Id
    @NotNull(message = "角色ID不能为空")
    @Size(min = 1,max = 255,message = "角色ID长度不符合规范")
    private String roleId;
    //角色名称
    @NotNull(message = "角色名称不能为空")
    @Size(min = 1,max = 255,message = "角色名称长度不符合规范")
    private String roleName;
    //职位Id
    @NotNull(message = "职位ID不能为空")
    @Size(min = 1,max = 255,message = "职位ID长度不符合规范")
    private String titleId;
    //职位名称
    @NotNull(message = "职位名称不能为空")
    @Size(min = 1,max = 255,message = "职位名称姓名长度不符合规范")
    private String titleName;

    public PersonInformationParams() {

    }

    public PersonInformationParams(String personId, String personName, String projectId, String projectName, String organizationId, String organizationName, String roleId, String roleName, String titleId, String titleName) {
        this.personId = personId;
        this.personName = personName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.titleId = titleId;
        this.titleName = titleName;
    }
}
