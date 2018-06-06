package net.cdsunrise.alps.ewp.eiamanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.cdsunrise.alps.ewp.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.eiamanage.entity.ProcessInformation;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.AccessoryParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessPageParams;
import net.cdsunrise.alps.ewp.eiamanage.repository.MaterialsMapper;
import net.cdsunrise.alps.ewp.eiamanage.repository.ProcessInformationMapper;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.LineChartReturns;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.eiamanage.service.ProcessInformationService;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;
import net.cdsunrise.alps.ewp.eiamanage.utils.StringUtils;
import net.cdsunrise.alps.ewp.eiamanage.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("processInformationService")
public class ProcessInformationServiceImpl implements ProcessInformationService {

    @Autowired
    private ProcessInformationMapper processInformationMapper;
    @Autowired
    private MaterialsService materialsService;
    @Autowired
    private MaterialsMapper materialsMapper;

    @Override
    @Transactional
    public int add(ProcessInformationParams processInformationParams) {
        ProcessInformation processInformation = new ProcessInformation();
        BeanUtils.copyProperties(processInformationParams,processInformation);
        processInformation.setId(StringUtils.getUUID());
        processInformation.setIsDel(0);
        processInformation.setVersion(1);
        int result = processInformationMapper.insert(processInformation);

        //附件
        List<AccessoryParams> accessoryParamsList = processInformationParams.getAccessoryParamsList();
        if(!CollectionUtils.isEmpty(accessoryParamsList)){
            for (AccessoryParams accessoryParams : accessoryParamsList) {
                MaterialsParams materialsParams = new MaterialsParams();
                BeanUtils.copyProperties(accessoryParams,materialsParams);
                materialsParams.setProjectId(processInformation.getId());
                materialsService.add(materialsParams);
            }
        }
        return result;
    }

    @Override
    public List<ProcessInformationReturns> getList() {
        return processInformationMapper.getList();
    }

//    @Override
//    public Page<ProcessInformationReturns> getListByPage(int pageNum,int pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        return processInformationMapper.getListByPage();
//    }

    @Override
    @Transactional
    public int update(ProcessInformationParams processInformationParams) {
        ProcessInformation processInformation = processInformationMapper.selectByPrimaryKey(processInformationParams.getId());
        if(processInformation == null){
            return 0;
        }
        BeanUtils.copyProperties(processInformationParams,processInformation);
        int result = processInformationMapper.updateByPrimaryKeySelective(processInformation);

        //删除之前的附件
        materialsMapper.deleteByRelevanceId(processInformation.getId());
        //重新添加附件
        List<AccessoryParams> accessoryParamsList = processInformationParams.getAccessoryParamsList();
        if(!CollectionUtils.isEmpty(accessoryParamsList)){
            for (AccessoryParams accessoryParams : accessoryParamsList) {
                MaterialsParams materialsParams = new MaterialsParams();
                BeanUtils.copyProperties(accessoryParams,materialsParams);
                materialsParams.setProjectId(processInformation.getId());
                materialsService.add(materialsParams);
            }
        }
        return result;
    }

    @Override
    public int delete(String id) {
        ProcessInformation processInformation = processInformationMapper.selectByPrimaryKey(id);
        if(processInformation == null){
            return 0;
        }
        processInformation.setIsDel(1);
        processInformation.setVersion(1);
        int result = processInformationMapper.updateByPrimaryKeySelective(processInformation);
        return result;
    }

    @Override
    public ProcessInformationReturns getDetails(String id) {
        ProcessInformationReturns processInformationReturns = processInformationMapper.getDetails(id);
        return processInformationReturns;
    }

    @Override
    public PageUtils<ProcessInformationReturns> getListByPageHelper(ProcessPageParams processPageParams) {
        PageUtils<ProcessInformationReturns> pageResult = new PageUtils<>();
        PageHelper.startPage((processPageParams.getPageNum()==null?1:processPageParams.getPageNum()),
                (processPageParams.getPageSize()) == null?10:processPageParams.getPageSize());
        Map<String,Object> requestParam = new HashMap<>();
        requestParam.put("startTime",TimeUtils.stringToDate(processPageParams.getStartTime()));
        requestParam.put("endTime",TimeUtils.stringToDate(processPageParams.getEndTime()));
        List<ProcessInformationReturns> processInformationReturnsList = processInformationMapper.getListByPageHelper(requestParam);
        if (processInformationReturnsList != null) {
            PageInfo<ProcessInformationReturns> pageInfo = new PageInfo<>(processInformationReturnsList);
            pageResult.setCurrentSize(pageInfo.getSize());
            pageResult.setTotalPages(pageInfo.getPages());
            pageResult.setTotalCount(pageInfo.getTotal());
            pageResult.setPageNum(pageInfo.getPageNum());
            pageResult.setList(processInformationReturnsList);
        }
        return pageResult;
    }

    @Override
    public List<LineChartReturns> getLineChart(String id) {
        List<LineChartReturns> result = processInformationMapper.getLineChart(id);
        return result;
    }
}
