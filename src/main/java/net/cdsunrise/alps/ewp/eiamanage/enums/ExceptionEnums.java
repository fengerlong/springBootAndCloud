package net.cdsunrise.alps.ewp.eiamanage.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    SYS_ERROR(101,"系统异常"),
    PARAM_ERROR(102,"参数异常"),
    ACCESS_MODE(103,"访问方式不正确"),

    ADD_FAILED(104,"添加失败"),
    PERSON_MESSAGE(105,"人员信息"),
    PARAM_ERROE(106,"参数错误"),
    ID_NOT_NULL(107,"ID不能为空"),
    PERSON_NOT_EXITS(108,"人员不存在"),
    UPDATE_PERSON_FAILED(109,"修改失败"),
    ACCESSORY(110,"附件信息"),
    PAPER_NOT_EXITS(111,"文件不存在"),
    PROCESS_INFORMATION(112,"过程信息"),
    PROCESS_NOT_EXITS(113,"进程信息不存在"),
    TIME_FORMAT_ERROR(114,"时间格式不正确"),
    PARAM_TYPE_ERROR(115,"参数类型不正确");


    private Integer code;

    private String message;

    ExceptionEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
