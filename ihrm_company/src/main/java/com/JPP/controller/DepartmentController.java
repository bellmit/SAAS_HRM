package com.JPP.controller;

import com.JPP.common.controller.BaseController;
import com.JPP.common.entity.Result;
import com.JPP.common.entity.ResultCode;
import com.JPP.domain.company.Company;
import com.JPP.domain.company.Department;
import com.JPP.domain.company.response.DeptListResult;
import com.JPP.service.CompanyService;
import com.JPP.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    /**
     * 添加部门
     * */
    @RequestMapping(value = "departments",method = RequestMethod.POST)
    public Result addDept(@RequestBody Department department){
        departmentService.addDept(department);
        return Result.SUCCESS();
    }

    /**
     * 删除部门
     * */
    @RequestMapping(value = "departments/{departmentID}",method = RequestMethod.DELETE)
    public Result delDept(@PathVariable("departmentID") String departmentID){
        departmentService.del(departmentID);
        return Result.SUCCESS();
    }

    /**
     * 修改部门
     * */
    @RequestMapping(value = "departments/{departmentID}", method = RequestMethod.PUT)
    public Result updateDept(@PathVariable("departmentID") String departmentID, @RequestBody Department department){
       department.setId(departmentID);
       departmentService.update(department);
       return Result.SUCCESS();
    }

    /**
     * 查询全部部门
     * */
    @RequestMapping(value = "departments",method = RequestMethod.GET)
    public Result findAll(){
        Company company = companyService.findById(parseCompanyId());
        List<Department> list = departmentService.findAll(parseCompanyId());
        return new Result(ResultCode.SUCCESS,new DeptListResult(company,list));
    }

    /**
     * 根据id查询部门
     * */
    @RequestMapping(value = "departments/{departmentID}",method = RequestMethod.GET)
    public Result findById(@PathVariable("departmentID") String departmentID){
        Department department = departmentService.findById(departmentID);
        return new Result(ResultCode.SUCCESS,department);
    }

}
