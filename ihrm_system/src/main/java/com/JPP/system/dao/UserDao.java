package com.JPP.system.dao;

import com.JPP.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User, String>,
        JpaSpecificationExecutor<User> {
}
