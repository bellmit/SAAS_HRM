package com.JPP.service;

import com.JPP.common.server.BaseService;
import com.JPP.common.utils.IdWorker;
import com.JPP.dao.DepartmentDao;
import com.JPP.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DepartmentService extends BaseService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加部门
     * */
    @Transactional
    public void addDept(Department department){
        department.setId(idWorker.nextId()+"");
        department.setCreateTime(new Date());
        departmentDao.save(department);
    }

    /**
     * 删除部门
     * */
    @Transactional
    public void del(String id){
        departmentDao.deleteById(id);
    }

    /**
     * 根据id查询部门
     * */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Department findById(String id){
        return departmentDao.findById(id).get();
    }

    /**
     * 修改部门
     * */
    @Transactional
    public void update(Department department){
        Department dept = departmentDao.findById(department.getId()).get();
        dept.setName(department.getName());
        dept.setPid(department.getPid());
        dept.setManagerId(department.getManagerId());
        dept.setIntroduce(department.getIntroduce());
        dept.setManager(department.getManager());
        departmentDao.save(dept);
    }

    /**
     * 查询全部部门
     * */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> findAll(String companyId){
        return departmentDao.findAll(getSpec(companyId));
    }
}
