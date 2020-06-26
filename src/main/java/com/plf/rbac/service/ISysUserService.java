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

    Page<SysUser> findUserPageByName(Page<SysUser> page, String username, String realname);
}
