package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ProcessPageParams extends PageParams{

    private static final long serialVersionUID = 9016186517129147920L;

    private String startTime;

    private String endTime;
}
