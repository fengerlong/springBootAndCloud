package net.cdsunrise.alps.ewp.eiamanage.returnEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInformationReturns implements Serializable {

    private static final long serialVersionUID = -7179779945408913703L;

    private String id;

    private String projectId;

    private String projectName;

    private String organizationId;

    private String organizationName;

    private String personId;

    private String personName;

    private String roleId;

    private String roleName;

    private String titleId;

    private String titleName;
    //联系电话
    private String phone;
    //邮箱地址
    private String email;
}
