package com.plf.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysPermission;
import com.plf.rbac.entity.SysRole;
import com.plf.rbac.mapper.SysPermissionMapper;
import com.plf.rbac.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Page<SysPermission> findPermissionPageByName(Page<SysPermission> page, String permissionName){
        QueryWrapper<SysPermission> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(permissionName)){
            wrapper.like("name",permissionName);
        }
        return sysPermissionMapper.selectPage(page,wrapper);
    }
}
