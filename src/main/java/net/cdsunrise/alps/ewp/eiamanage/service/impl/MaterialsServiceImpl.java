package net.cdsunrise.alps.ewp.eiamanage.service.impl;

import net.cdsunrise.alps.ewp.eiamanage.entity.Materials;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsPageParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.eiamanage.repository.MaterialsMapper;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.MaterialsReturns;
import net.cdsunrise.alps.ewp.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.eiamanage.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("materialsInterface")
public class MaterialsServiceImpl implements MaterialsService {

    @Autowired
    private MaterialsMapper materialsMapper;

    @Override
    public int add(MaterialsParams materialsParams) {
        Materials materials = new Materials();
        materials.setId(StringUtils.getUUID());
        materials.setEditTime(new Date());
        materials.setIsDel(0);
        materials.setMaterialsAddress(materialsParams.getAddress());
        materials.setMaterialsName(materialsParams.getName());
        materials.setMaterialsType(materialsParams.getType());
        materials.setRelevanceId(materialsParams.getProjectId());
        materials.setUploadPersonId(materialsParams.getSubmiterId());
        materials.setUploadPersonName(materialsParams.getSubmiterName());
        materials.setVersion(1);
        return materialsMapper.insertSelective(materials);
    }

    @Override
    public List<MaterialsReturns> getListByProjectId(String projectId) {
        return materialsMapper.getListByProjectId(projectId);
    }

    @Override
    public Map<String,Object> getListByPage(MaterialsPageParams materialsPageParams) {
        Integer pageNum = materialsPageParams.getPageNum();
        Integer pageSize = materialsPageParams.getPageSize();

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id",materialsPageParams.getId());
        params.put("pageNumber", (pageNum - 1) * pageSize);
        params.put("pageSize", pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        List<MaterialsReturns> list = new ArrayList<>();
        Integer total = 0;
        list = materialsMapper.getListByPage(params);
        total = materialsMapper.getListByPageCount(params);
        map.put("list",list);
        map.put("total",total);;
        map.put("pages",Math.ceil( total / pageSize));
        map.put("size",list.size());
        map.put("pageSize",pageSize);
        map.put("pageNum",pageNum);
        return map;
    }

    @Override
    public int update(MaterialsParams materialsParams) {
        Materials materials = materialsMapper.selectByPrimaryKey(materialsParams.getId());
        materials.setEditTime(new Date());
        materials.setMaterialsAddress(materialsParams.getAddress());
        materials.setMaterialsName(materialsParams.getName());
        materials.setMaterialsType(materialsParams.getType());
        materials.setRelevanceId(materialsParams.getProjectId());
        materials.setUploadPersonId(materialsParams.getSubmiterId());
        materials.setUploadPersonName(materialsParams.getSubmiterName());
        return materialsMapper.updateByPrimaryKeySelective(materials);
    }

    @Override
    public int delete(String id) {
        Materials materials = materialsMapper.selectByPrimaryKey(id);
        materials.setIsDel(1);
        return materialsMapper.updateByPrimaryKeySelective(materials);
    }

    @Override
    public MaterialsReturns getDetails(String id) {
        return materialsMapper.selectById(id);
    }
}
