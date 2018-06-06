package net.cdsunrise.alps.ewp.eiamanage.service;

import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsPageParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.MaterialsReturns;

import java.util.List;
import java.util.Map;

public interface MaterialsService {

    /**
     * 增加附件
     * @param materialsParams
     * @return
     */
    int add(MaterialsParams materialsParams);

    /**
     * 获取附件列表(根据项目ID)
     * @return
     */
    List<MaterialsReturns> getListByProjectId(String projectId);

    /**
     * 分页查找
     * @return
     */
    Map<String,Object> getListByPage(MaterialsPageParams materialsPageParams);

    /**
     * 更新附件
     * @param materialsParams
     * @return
     */
    int update(MaterialsParams materialsParams);

    /**
     * 删除附件
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据Id获取附件详情
     * @param id
     * @return
     */
    MaterialsReturns getDetails(String id);
}
