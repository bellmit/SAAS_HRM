package com.JPP.service;

import com.JPP.common.utils.IdWorker;
import com.JPP.dao.CompanyDao;
import com.JPP.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加企业
     * */
    @Transactional
    public void addCompany(Company company){
        company.setId(idWorker.nextId()+"");
        company.setAuditState("0"); //0：未审核，1：已审核
        company.setState(1); //0.未激活，1：已激活
        companyDao.save(company);
    }

    /**
     * 根据id删除企业
     * */
    @Transactional
    public void delCompany(String id){
        companyDao.deleteById(id);
    }

    /**
     * 更新企业信息
     * */
    @Transactional
    public void updateCompany(Company company){
        companyDao.save(company);
    }

    /**
     * 根据id查询企业信息
     * */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Company findById(String id){
        return companyDao.findById(id).get();
    }

    /**
     * 查询全部企业信息
     * */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
