package net.cdsunrise.alps.ewp.eiamanage.repository;

import net.cdsunrise.alps.ewp.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonPageParams;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("personInformationMapper")
public interface PersonInformationMapper {

    int deleteByPrimaryKey(String id);

    int insert(PersonInformation record);

    int insertSelective(PersonInformation record);

    PersonInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInformation record);

    int updateByPrimaryKey(PersonInformation record);

    List<PersonInformation> getList();

    List<PersonInformation> getListByPage(Map<String, Object> params);

    Integer getListByPageCount(Map<String, Object> params);

    List<PersonInformation> getListByPageHelper(PersonPageParams personPageParams);
}