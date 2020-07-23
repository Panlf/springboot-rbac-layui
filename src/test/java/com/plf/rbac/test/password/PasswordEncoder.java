package com.plf.rbac.test.password;

import cn.hutool.crypto.digest.MD5;
import org.junit.Test;
import org.springframework.util.DigestUtils;

public class PasswordEncoder {

    @Test
    public void test(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex("123456".getBytes()).getBytes()).toString());
    }

}
