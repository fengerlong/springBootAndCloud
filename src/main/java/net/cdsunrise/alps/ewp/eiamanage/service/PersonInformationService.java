package net.cdsunrise.alps.ewp.eiamanage.service;

import net.cdsunrise.alps.ewp.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonPageParams;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface PersonInformationService {

    /**
     * 增加人员信息
     * @param personInformationParams
     * @return
     */
    int add(PersonInformationParams personInformationParams);

    /**
     * 获取人员信息列表
     * @return
     */
    List<PersonInformation> getList();

    /**
     * 带有分页的数据返回
     * @return
     */
    Map<String,Object> getListByPage(PersonPageParams personPageParams);

    /**
     * 更新人员信息
     * @param personInformationParams
     * @return
     */
    int update(PersonInformationParams personInformationParams);

    /**
     * 删除人员信息
     * @param id 人员Id
     * @return
     */
    int delete(String id);

    /**
     * 获取人员信息详情
     * @param id
     * @return
     */
    PersonInformation getDetails(String id);

    /**
     * 利用分页插件获取人员列表
     * @param personPageParams
     * @return
     */
    PageUtils<PersonInformation> getListByPageHelper(PersonPageParams personPageParams);
}
