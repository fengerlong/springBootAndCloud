package net.cdsunrise.alps.ewp.eiamanage.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProcessInformation implements Serializable {

    private static final long serialVersionUID = -7139680485302779386L;

    private String id;

    private String projectId;

    private String projectName;

    private String messageTheme;

    private String typeId;

    private String typeName;

    private String stateId;

    private String stateName;

    private String content;

    private String submitterId;

    private String submitterName;

    private Date createTime;

    private Date editTime;

    private Integer version;

    private Integer isDel;
}