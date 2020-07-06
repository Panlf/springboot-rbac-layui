package com.plf.rbac.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.base.model.ResponseResult;
import com.plf.rbac.entity.SysUser;
import com.plf.rbac.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        sysUserService.save(sysUser);
        return ResponseResult.success(sysUser);
    }

    @GetMapping("/page")
    public ResponseResult<Page<SysUser>> getUserPage(@RequestParam(defaultValue = "10") Integer pageSize,
                                                     @RequestParam(defaultValue = "0") Integer pageNum,
                                                     String username,
                                                     String realname){
        Page<SysUser> page = new Page<>(pageNum,pageSize);
        Page<SysUser> list = sysUserService.findUserPageByName(page,username,realname);
        return ResponseResult.success(list);
    }
}
