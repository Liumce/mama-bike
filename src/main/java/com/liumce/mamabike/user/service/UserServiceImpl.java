package com.liumce.mamabike.user.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumce.mamabike.common.exception.MaMaBikeException;
import com.liumce.mamabike.security.AESUtil;
import com.liumce.mamabike.security.Base64Util;
import com.liumce.mamabike.security.RSAUtil;
import com.liumce.mamabike.user.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by liumce on 18/08/10
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String login(String data, String key) throws MaMaBikeException {

        String token = null;

        String decryptData = null;

        try {
            byte[] aesKey = RSAUtil.decryptByPrivateKey(Base64Util.decode(key));
            decryptData = AESUtil.decrypt(data,new String(aesKey,"UTF-8"));
            if (decryptData == null) {
                throw new Exception();
            }
            JSONObject jsonObject = JSON.parseObject(decryptData);
            String mobile = jsonObject.getString("mobile");
            String code = jsonObject.getString("code");
            if (StringUtils.isBlank(mobile) || StringUtils.isBlank(code)) {
                throw new Exception();
            }

            // 去redis取验证码 比较手机号码和验证码是否匹配


            //判断用户是否在数据库存在 存在生成token 存redis
            //如果不存在 帮她注册  插入数据库


        }catch (Exception e) {
            log.error("Fail to dectypt data",e);
            throw new MaMaBikeException("数据解析错误");
        }

        return null;
    }
}
