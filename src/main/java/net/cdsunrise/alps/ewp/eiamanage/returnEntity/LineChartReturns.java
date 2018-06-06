package net.cdsunrise.alps.ewp.eiamanage.returnEntity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LineChartReturns implements Serializable {

    //进度名称
    private String stateName;
    //时间
    private Date time;
}
