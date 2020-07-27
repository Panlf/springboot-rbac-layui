package com.plf.rbac.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.base.model.ResponseResult;
import com.plf.rbac.entity.SysUser;
import com.plf.rbac.service.ISysUserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @PostMapping("/save")
    public ResponseResult<SysUser> saveUser(SysUser sysUser){
        if(StrUtil.isEmpty(sysUser.getUsername()) || StrUtil.isEmpty(sysUser.getPassword())){
            return ResponseResult.fail("用户名或者密码必不能为空");
        }
        SysUser oSysUser = sysUserService.findByUsername(sysUser.getUsername());

        if(oSysUser!=null) {
            return ResponseResult.fail("用户名已存在请修改");
        }

        //对密码进行加密，之后可以集成shiro
        sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()).toString());


        sysUserService.save(sysUser);

        return ResponseResult.success(sysUser);
    }

    @PostMapping("/login")
    public ResponseResult<SysUser> login(SysUser sysUser){
        if(StrUtil.isEmpty(sysUser.getUsername()) || StrUtil.isEmpty(sysUser.getPassword())){
            return ResponseResult.fail("用户名或者密码必不能为空");
        }
        SysUser oSysUser = sysUserService.findByUsername(sysUser.getUsername());
        if(oSysUser!=null && oSysUser.getPassword().equals(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()).toString())){
            return ResponseResult.success(sysUser);
        }else{
            return ResponseResult.fail("用户名或者密码错误");
        }
    }

    @GetMapping("/page")
    public ResponseResult<Page<SysUser>> getUserPage(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer limit,
                                                     String username,
                                                     String realname){
        Page<SysUser> pageUser = new Page<>(page,limit);
        Page<SysUser> list = sysUserService.findUserPageByName(pageUser,username,realname);
        return ResponseResult.success(list);
    }
}
