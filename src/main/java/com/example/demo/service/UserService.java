package com.example.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.po.User;

public interface UserService extends IService<User> {
    User findUserByLoginName(String name);
}
