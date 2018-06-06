package net.cdsunrise.alps.ewp.eiamanage.paramEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper=false)
public class MaterialsPageParams extends PageParams {

    private static final long serialVersionUID = -2984774184209597652L;

    @NotNull(message = "项目Id不能为空")
    private String id;
}
