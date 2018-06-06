package net.cdsunrise.alps.ewp.eiamanage.repository;

import net.cdsunrise.alps.ewp.eiamanage.entity.ProcessInformation;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessPageParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.LineChartReturns;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("processInformationMapper")
public interface ProcessInformationMapper {

    int deleteByPrimaryKey(String id);

    int insert(ProcessInformation record);

    int insertSelective(ProcessInformation record);

    ProcessInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProcessInformation record);

    int updateByPrimaryKey(ProcessInformation record);

    List<ProcessInformationReturns> getList();

    ProcessInformationReturns getDetails(String id);

    List<ProcessInformationReturns> getListByPageHelper(Map<String, Object> processPageParams);

    List<LineChartReturns> getLineChart(String id);

//    Page<ProcessInformationReturns> getListByPage();
}