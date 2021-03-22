package com.JPP.controller;

import com.JPP.common.entity.Result;
import com.JPP.common.entity.ResultCode;
import com.JPP.domain.company.Company;
import com.JPP.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result add(@RequestBody Company company){
        companyService.addCompany(company);
        return Result.SUCCESS();
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result list(){
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("companyId") String companyId){
        Company company = companyService.findById(companyId);
        return new Result(ResultCode.SUCCESS,company);
    }

    @RequestMapping(value = "/{companyId}" , method = RequestMethod.PUT)
    public Result update(@PathVariable("companyId") String companyId , @RequestBody Company company){
        Company companyById = companyService.findById(companyId);
        companyById.setName(company.getName());
        companyById.setRemarks(company.getRemarks());
        companyById.setState(company.getState());
        companyById.setAuditState(company.getAuditState());
        companyService.updateCompany(company);
        return Result.SUCCESS();
    }

    @RequestMapping(value = "/{companyId}" , method = RequestMethod.DELETE)
    public Result del(@PathVariable("companyId") String companyId){
        companyService.delCompany(companyId);
        return Result.SUCCESS();
    }
}
