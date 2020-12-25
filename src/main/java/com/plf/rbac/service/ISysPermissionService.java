package com.plf.rbac.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
public interface ISysPermissionService extends IService<SysPermission> {
    Page<SysPermission> findPermissionPageByName(Page<SysPermission> page, String permissionName);
}
