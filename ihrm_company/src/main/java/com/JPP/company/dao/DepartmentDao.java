package com.JPP.company.dao;


import com.JPP.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户dao接口
 **/
public interface DepartmentDao
        extends JpaRepository<Department,String>, JpaSpecificationExecutor<Department> {
    Department findByCodeAndCompanyId(String code, String companyId);
}