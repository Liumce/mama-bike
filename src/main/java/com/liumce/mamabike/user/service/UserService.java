package com.liumce.mamabike.user.service;

import com.liumce.mamabike.common.exception.MaMaBikeException;

/**
 * Create by liumce on 18/08/10
 */
public interface UserService {

    String login(String data, String key) throws MaMaBikeException;
}
