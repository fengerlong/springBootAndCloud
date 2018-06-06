package net.cdsunrise.alps.ewp.eiamanage.enums;

import lombok.Getter;

@Getter
public enum  fileEnums {

    DOCUMENT(0,"文档"),

    PICTURE(1,"图片");

    private Integer code;

    private String type;

    fileEnums(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
