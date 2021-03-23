package com.JPP.system.service;

import com.JPP.common.utils.IdWorker;
import com.JPP.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;


}
