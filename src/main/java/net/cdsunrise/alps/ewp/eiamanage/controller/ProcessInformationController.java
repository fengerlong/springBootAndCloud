package net.cdsunrise.alps.ewp.eiamanage.controller;

import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.eiamanage.paramEntity.ProcessPageParams;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.LineChartReturns;
import net.cdsunrise.alps.ewp.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.eiamanage.service.ProcessInformationService;
import net.cdsunrise.alps.ewp.eiamanage.utils.PageUtils;
import net.cdsunrise.alps.ewp.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.eiamanage.viewObject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/process")
@Slf4j
public class ProcessInformationController {

    @Autowired
    private ProcessInformationService processInformationService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid ProcessInformationParams processInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = processInformationService.add(processInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.ADD_FAILED);
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid ProcessInformationParams processInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(processInformationParams.getId() == null || "".equals(processInformationParams.getId())){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.ID_NOT_NULL);
        }
        int result = processInformationService.update(processInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail(ExceptionEnums.UPDATE_PERSON_FAILED);
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.ADD_FAILED);
        }
        ProcessInformationReturns processInformationReturns = processInformationService.getDetails(id);
        if(processInformationReturns == null){
            throw new CustomException(ExceptionEnums.PROCESS_NOT_EXITS);
        }
        return ResultUtils.successWithData(processInformationReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，id={}",id);
            throw new CustomException(ExceptionEnums.ADD_FAILED);
        }
        int result = processInformationService.delete(id);
        if(result == 0){
            throw new CustomException(ExceptionEnums.PROCESS_NOT_EXITS);
        }
        return ResultUtils.success();
    }

    @PostMapping("/getList")
    private Result getList(@RequestBody @Valid ProcessPageParams processPageParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+"，processPageParams={}",processPageParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        PageUtils<ProcessInformationReturns> result = processInformationService.getListByPageHelper(processPageParams);
        return ResultUtils.successWithData(result);
    }

    @GetMapping("/getLineChart")
    private Result getLineChart(String id){
        if(id == null || "".equals(id)){
            log.error("【"+ExceptionEnums.PROCESS_INFORMATION.getMessage()+"】"
                    +ExceptionEnums.PARAM_ERROR.getMessage()+",id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        List<LineChartReturns> result = processInformationService.getLineChart(id);
        return ResultUtils.successWithData(result);
    }
}
