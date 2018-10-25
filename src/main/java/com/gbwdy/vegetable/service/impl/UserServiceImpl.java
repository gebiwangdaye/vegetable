package com.gbwdy.vegetable.service.impl;

import com.gbwdy.vegetable.dao.UserDao;
import com.gbwdy.vegetable.service.UserService;
import com.gbwdy.vegetable.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public User findUser(String username,String password) {
        return userDao.findUser(username,password);
    }
}
