package com.plf.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.entity.SysUser;
import com.plf.rbac.mapper.SysUserMapper;
import com.plf.rbac.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Page<SysUser> findUserPageByName(Page<SysUser> page,String username,String realname) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(username)){
            wrapper.like("username",username);
        }
        if(!StringUtils.isEmpty(realname)){
            wrapper.like("realname",realname);
        }
        wrapper.orderByDesc("id");
        return sysUserMapper.selectPage(page,wrapper);
    }

    @Override
    public SysUser findByUsername(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return sysUserMapper.selectOne(wrapper);
    }
}
