package com.airline.userdemo.service;

import com.airline.userdemo.commons.GenericServiceImpl;
import com.airline.userdemo.model.User;
import com.airline.userdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserServiceAPI{

    @Autowired
    private UserRepository userRepository;
    @Override
    public CrudRepository<User, String> getDao() {
        return null;
    }
}
