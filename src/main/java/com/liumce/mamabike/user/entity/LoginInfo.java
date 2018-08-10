package com.liumce.mamabike.user.entity;

import lombok.Data;

/**
 * Create by liumce on 18/08/10
 */

@Data
public class LoginInfo {

    /* 登录信息密文 */
    private String data;
    /* RSA加密的AES的密钥*/
    private String key;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
