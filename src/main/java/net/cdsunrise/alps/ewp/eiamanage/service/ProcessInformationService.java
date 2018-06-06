package net.cdsunrise.alps.ewp.eiamanage.service;

import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessPageParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.LineChartReturns;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;

import java.util.List;

public interface ProcessInformationService {

    /**
     * 增加过程管理
     * @param processInformationParams
     * @return
     */
    int add(ProcessInformationParams processInformationParams);

    /**
     * 获得过程管理列表
     * @return
     */
    List<ProcessInformationReturns> getList();

    /**
     * 分页查询结果
     * @return
     */
//    Page<ProcessInformationReturns> getListByPage(int pageNum,int pageSize);

    /**
     * 更新过程管理
     * @param processInformationParams
     * @return
     */
    int update(ProcessInformationParams processInformationParams);

    /**
     * 删除过程管理
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 获得过程管理详情
     * @param id
     * @return
     */
    ProcessInformationReturns getDetails(String id);

    /**
     * 获得进程列表
     * @param processPageParams
     * @return
     */
    PageUtils<ProcessInformationReturns> getListByPageHelper(ProcessPageParams processPageParams);

    /**
     * 获取进度进程
     * @param id
     * @return
     */
    List<LineChartReturns> getLineChart(String id);
}
