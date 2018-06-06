package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class PersonPageParams extends PageParams{

    private static final long serialVersionUID = 9016186517129147920L;
    //人员姓名
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
}
