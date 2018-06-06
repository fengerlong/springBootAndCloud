package net.cdsunrise.alps.ewp.eiamanage.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Materials implements Serializable {

    private static final long serialVersionUID = -3346562486997066979L;

    private String id;

    private String relevanceId;

    private String materialsAddress;

    private String materialsName;

    private Integer materialsType;

    private String uploadPersonId;

    private String uploadPersonName;

    private Date createTime;

    private Date editTime;

    private Integer version;

    private Integer isDel;
}