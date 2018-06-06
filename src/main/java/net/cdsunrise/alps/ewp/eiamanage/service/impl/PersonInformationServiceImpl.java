package net.cdsunrise.alps.ewp.eiamanage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.cdsunrise.alps.ewp.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonPageParams;
import net.cdsunrise.alps.ewp.eiamanage.repository.PersonInformationMapper;
import net.cdsunrise.alps.ewp.eiamanage.service.PersonInformationService;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;
import net.cdsunrise.alps.ewp.eiamanage.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("personInformationService")
public class PersonInformationServiceImpl implements PersonInformationService {

    @Autowired
    private PersonInformationMapper personInformationMapper;

    @Override
    public int add(PersonInformationParams personInformationParams) {
        PersonInformation personInformation = new PersonInformation();
        BeanUtils.copyProperties(personInformationParams,personInformation);
        personInformation.setId(StringUtils.getUUID());
        personInformation.setIsDel(0);
        personInformation.setVersion(1);
        personInformation.setEditTime(new Date());
        return personInformationMapper.insertSelective(personInformation);
    }

    @Override
    public List<PersonInformation> getList() {
        return personInformationMapper.getList();
    }

    @Override
    public Map<String,Object> getListByPage(PersonPageParams personPageParams) {
        Integer pageNum = personPageParams.getPageNum();
        Integer pageSize = personPageParams.getPageSize();

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("name",personPageParams.getName());
        params.put("pageNumber", (pageNum - 1) * pageSize);
        params.put("pageSize", pageSize);

        Map<String,Object> map = new HashMap<String,Object>();
        List<PersonInformation> list = new ArrayList<>();
        Integer total = 0;
        list = personInformationMapper.getListByPage(params);
        total = personInformationMapper.getListByPageCount(params);
        map.put("list",list);
        map.put("total",total);;
        map.put("pages",Math.ceil( total / pageSize));
        map.put("size",list.size());
        map.put("pageSize",pageSize);
        map.put("pageNum",pageNum);
        return map;
    }

    @Override
    public int update(PersonInformationParams personInformationParams) {
        PersonInformation personInformation = personInformationMapper.selectByPrimaryKey(personInformationParams.getId());
        BeanUtils.copyProperties(personInformationParams,personInformation);
        personInformation.setEditTime(new Date());
        return personInformationMapper.updateByPrimaryKeySelective(personInformation);
    }

    @Override
    public int delete(String id) {
        PersonInformation personInformation = personInformationMapper.selectByPrimaryKey(id);
        if(personInformation != null){
            personInformation.setIsDel(1);
            return personInformationMapper.updateByPrimaryKeySelective(personInformation);
        }else {
            return 0;
        }
    }

    @Override
    public PersonInformation getDetails(String id) {
        return personInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageUtils<PersonInformation> getListByPageHelper(PersonPageParams personPageParams) {
        ;
        PageUtils<PersonInformation> pageResult = new PageUtils<>();
        PageHelper.startPage((personPageParams.getPageNum() == null) ? 1 : personPageParams.getPageNum(),
                (personPageParams.getPageSize()== null ? 10 :personPageParams.getPageSize()));
        List<PersonInformation> personInformationList = personInformationMapper.getListByPageHelper(personPageParams);
        if (personInformationList != null) {
            PageInfo<PersonInformation> pageInfo = new PageInfo<>(personInformationList);
            pageResult.setCurrentSize(pageInfo.getSize());
            pageResult.setTotalPages(pageInfo.getPages());
            pageResult.setTotalCount(pageInfo.getTotal());
            pageResult.setPageNum(pageInfo.getPageNum());
            pageResult.setList(personInformationList);
        }
        return pageResult;
    }
}
