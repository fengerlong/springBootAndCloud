package net.cdsunrise.alps.ewp.eiamanage.controller;

import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsPageParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.MaterialsReturns;
import net.cdsunrise.alps.ewp.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.eiamanage.viewObject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/materials")
@Slf4j
public class MaterialsController {

    @Autowired
    private MaterialsService materialsService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid MaterialsParams materialsParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+",materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = materialsService.add(materialsParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.ADD_FAILED);
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid MaterialsParams materialsParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(materialsParams.getId() == null || "".equals(materialsParams.getId())){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),ExceptionEnums.ID_NOT_NULL.getMessage());
        }
        int result = materialsService.update(materialsParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.UPDATE_PERSON_FAILED);
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),ExceptionEnums.ID_NOT_NULL.getMessage());
        }
        MaterialsReturns materialsReturns = materialsService.getDetails(id);
        if(materialsReturns == null){
            throw new CustomException(ExceptionEnums.PAPER_NOT_EXITS);
        }
        return ResultUtils.successWithData(materialsReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),ExceptionEnums.ID_NOT_NULL.getMessage());
        }
        int result = materialsService.delete(id);
        return ResultUtils.success();
    }

    @PostMapping("/getListByPage")
    private Result getListByPage(@RequestBody @Valid MaterialsPageParams materialsPageParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ ExceptionEnums.ACCESSORY.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROE.getMessage()+"，materialsPageParams={}",materialsPageParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        Map<String,Object> result =  materialsService.getListByPage(materialsPageParams);
        return ResultUtils.successWithData(result);
    }
}
