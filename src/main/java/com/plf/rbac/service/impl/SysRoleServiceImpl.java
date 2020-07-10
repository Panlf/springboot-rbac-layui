package com.plf.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysRole;
import com.plf.rbac.entity.SysUser;
import com.plf.rbac.mapper.SysRoleMapper;
import com.plf.rbac.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public Page<SysRole> findRolePageByName(Page<SysRole> page, String roleName) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(roleName)){
            wrapper.like("name",roleName);
        }
        return sysRoleMapper.selectPage(page,wrapper);
    }
}
