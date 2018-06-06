package net.cdsunrise.alps.ewp.eiamanage.repository;

import net.cdsunrise.alps.ewp.eiamanage.entity.Materials;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.MaterialsReturns;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("materialsMapper")
public interface MaterialsMapper {

    int deleteByPrimaryKey(String id);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    List<MaterialsReturns> getListByProjectId(@Param("projectId") String projectId);

    MaterialsReturns selectById(@Param("id") String id);

    int deleteByRelevanceId(String id);

    List<MaterialsReturns> getListByPage(Map<String, Object> params);

    Integer getListByPageCount(Map<String, Object> params);
}