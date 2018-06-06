package net.cdsunrise.alps.ewp.eiamanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonInformation implements Serializable {

    private static final long serialVersionUID = -1979011230991439879L;

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

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date editTime;
    @JsonIgnore
    private Integer version;
    @JsonIgnore
    private Integer isDel;
}