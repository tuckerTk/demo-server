package com.example.demo.controller;

import com.example.demo.annotation.JwtIgnore;
import com.example.demo.config.Audience;
import com.example.demo.dto.LoginDTO;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtTokenUtil;
import com.example.demo.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys")
@Slf4j
public class LoginController {
    @Resource
    private Audience audience;
    @Resource
    @Lazy
    private UserService userService;
    @PostMapping("/login")
    @JwtIgnore
    public RestResponse login(HttpServletResponse response, @RequestBody LoginDTO loginDTO){
        if(loginDTO.getUserName().equals("admin") && loginDTO.getPassword().equals("123456")){
            String token = JwtTokenUtil.createJWT("1", loginDTO.getUserName(), "admin", audience);
            log.info("### 登录成功, token={} ###", token);

            // 将token放在响应头
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
            // 将token响应给客户端
            User user = userService.findUserByLoginName(loginDTO.getUserName());
            RestResponse result = RestResponse.success();
            Map<String,Object> data = new HashMap();
            data.put("sysMenuVoList",user.getMenus());
            data.put("sysRoleVoList",null);
            data.put("rolePermissionVoList",null);
            data.put("userInfo",user);
            data.put("token",token);
            result.setData(data);
            return result;
        }
        return RestResponse.failure("用户名或密码错误");
    }
    @GetMapping("/userInfo")
    public RestResponse userInfo(){
        return RestResponse.success().setData("您好");
    }
}
