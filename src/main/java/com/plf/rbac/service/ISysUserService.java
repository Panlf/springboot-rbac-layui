package com.plf.rbac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 动态根据参数分页查询用户
     * @param page
     * @param username
     * @param realname
     * @return
     */
    Page<SysUser> findUserPageByName(Page<SysUser> page, String username, String realname);

    /**
     * 根据用户查找用户
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
