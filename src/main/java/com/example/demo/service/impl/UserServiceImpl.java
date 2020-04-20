package com.example.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public User findUserByLoginName(String name) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("loginName", name);
        User u = baseMapper.selectUserByMap(map);
        return u;
    }
}
