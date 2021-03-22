package com.JPP.controller;

import com.JPP.common.entity.Result;
import com.JPP.common.entity.ResultCode;
import com.JPP.domain.company.Company;
import com.JPP.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
