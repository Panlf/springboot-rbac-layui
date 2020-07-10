package com.plf.rbac.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.base.model.ResponseResult;
import com.plf.rbac.entity.SysRole;
import com.plf.rbac.entity.SysUser;
import com.plf.rbac.service.ISysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @PostMapping("/save")
    public ResponseResult<SysRole> saveSysRole(SysRole sysRole){
        sysRoleService.save(sysRole);
        return ResponseResult.success(sysRole);
    }

    @GetMapping("/page")
    public ResponseResult<Page<SysRole>> getUserPage(@RequestParam(defaultValue = "10") Integer pageSize,
                                                     @RequestParam(defaultValue = "0") Integer pageNum,
                                                     String roleName){
        Page<SysRole> page = new Page<>(pageNum,pageSize);
        Page<SysRole> list = sysRoleService.findRolePageByName(page,roleName);
        return ResponseResult.success(list);
    }
}
