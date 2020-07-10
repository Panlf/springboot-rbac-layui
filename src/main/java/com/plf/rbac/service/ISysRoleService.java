package com.plf.rbac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.plf.rbac.entity.SysUser;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 根据角色名分页查询
     * @param page
     * @param roleName
     * @return
     */
    Page<SysRole> findRolePageByName(Page<SysRole> page, String roleName);
}
