package com.gbwdy.vegetable.service;

import com.gbwdy.vegetable.vo.User;

/**
 * @author gebiwangdaye
 * @date 2018/7/8
 */
public interface UserService {
    User findUser(String username,String password);
}
