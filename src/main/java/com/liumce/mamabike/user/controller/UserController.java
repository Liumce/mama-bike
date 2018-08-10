package com.liumce.mamabike.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.liumce.mamabike.common.constants.Constants;
import com.liumce.mamabike.common.exception.MaMaBikeException;
import com.liumce.mamabike.common.resp.ApiResult;
import com.liumce.mamabike.user.dao.UserMapper;
import com.liumce.mamabike.user.entity.LoginInfo;
import com.liumce.mamabike.user.entity.User;
import com.liumce.mamabike.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by liumce on 18/08/04
 */

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;



    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<String> login(@RequestBody LoginInfo loginInfo){

        ApiResult<String> resp = new ApiResult<>();
        try {
            String data = loginInfo.getData();
            String key = loginInfo.getKey();
            if (org.apache.commons.lang.StringUtils.isBlank(data) || org.apache.commons.lang.StringUtils.isBlank(key)) {
                throw new MaMaBikeException("参数校验失败");
            }
            String token = userService.login(data,key);
            resp.setData(token);
        }catch (MaMaBikeException e){
            resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
            resp.setMessage(e.getMessage());
        }catch (Exception e){
            log.error("Fail to login",e);
            resp.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
            resp.setMessage("内部错误");
        }
        return resp;
    }
}
