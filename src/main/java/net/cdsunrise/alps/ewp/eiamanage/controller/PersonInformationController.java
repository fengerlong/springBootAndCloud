package net.cdsunrise.alps.ewp.eiamanage.controller;

import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.PersonPageParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.PersonInformationReturns;
import net.cdsunrise.alps.ewp.eiamanage.service.PersonInformationService;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;
import net.cdsunrise.alps.ewp.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.eiamanage.viewObject.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonInformationController {

    @Autowired
    private PersonInformationService personInformationService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid PersonInformationParams personInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = personInformationService.add(personInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.ADD_FAILED);
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid PersonInformationParams personInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(personInformationParams.getId() == null || "".equals(personInformationParams.getId())){
            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"+ExceptionEnums.PARAM_ERROE+"，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.ID_NOT_NULL);
        }
        PersonInformation personInformation = personInformationService.getDetails(personInformationParams.getId());
        if(personInformation == null){
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),ExceptionEnums.PERSON_NOT_EXITS.getMessage());
        }else if(personInformation.getIsDel() == 1){
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"");
        }
        int result = personInformationService.update(personInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.UPDATE_PERSON_FAILED);
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.ID_NOT_NULL);
        }
        PersonInformation personInformation = personInformationService.getDetails(id);
        if(personInformation == null){
            throw new CustomException(ExceptionEnums.PERSON_NOT_EXITS);
        }
        PersonInformationReturns personInformationReturns = new PersonInformationReturns();
        BeanUtils.copyProperties(personInformation,personInformationReturns);
        //调用人员服务
        personInformationReturns.setPhone("123456");
        personInformationReturns.setEmail("1@163.com");
        return ResultUtils.successWithData(personInformationReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.ID_NOT_NULL);
        }
        int result = personInformationService.delete(id);
        if(result == 0){
            throw new CustomException(ExceptionEnums.PERSON_NOT_EXITS);
        }
        return ResultUtils.success();
    }

//    @PostMapping("/getListByPage")
//    private Result getListByPage(@RequestBody @Valid PersonPageParams personPageParams, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            log.error("【"+ ExceptionEnums.PERSON_MESSAGE.getMessage()+"】"
//                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，personPageParams={}",personPageParams);
//            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
//        }
//        Map<String, Object> map = personInformationService.getListByPage(personPageParams);
//        List<PersonInformation> personInformationList = (List<PersonInformation>) map.get("list");
//        List<PersonInformationReturns> personInformationReturnsList = new ArrayList<>();
//
//        if(!CollectionUtils.isEmpty(personInformationList)){
//            for (PersonInformation personInformation : personInformationList) {
//                PersonInformationReturns personInformationReturns = new PersonInformationReturns();
//
//                BeanUtils.copyProperties(personInformation,personInformationReturns);
//                //此部分访问人员服务（根据Id）
//                personInformationReturns.setPhone("123456789");
//                personInformationReturns.setEmail("1@163.com");
//                personInformationReturnsList.add(personInformationReturns);
//            }
//        }
//        map.put("list",personInformationReturnsList);
//        return ResultUtils.successWithData(map);
//    }

    @PostMapping("/getList")
    private Result getListByPageHelper(@RequestBody @Valid PersonPageParams personPageParams, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【" + ExceptionEnums.PERSON_MESSAGE.getMessage() + "】"
                    + ExceptionEnums.PARAM_ERROE.getMessage() + "，personPageParams={}", personPageParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        PageUtils<PersonInformation> result = personInformationService.getListByPageHelper(personPageParams);
        return ResultUtils.successWithData(result);
    }
}
