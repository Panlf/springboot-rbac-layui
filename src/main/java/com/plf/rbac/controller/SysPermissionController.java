package com.plf.rbac.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plf.rbac.base.model.ResponseResult;
import com.plf.rbac.entity.SysPermission;
import com.plf.rbac.entity.SysRole;
import com.plf.rbac.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@RestController
@RequestMapping("/sysPermission")
public class SysPermissionController {

    @Resource
    private ISysPermissionService sysPermissionService;


    @GetMapping("/page")
    public ResponseResult<Page<SysPermission>> getUserPage(@RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "0") Integer pageNum,
                                                           String permissionName){
        Page<SysPermission> page = new Page<>(pageNum,pageSize);
        Page<SysPermission> list = sysPermissionService.findPermissionPageByName(page,permissionName);
        return ResponseResult.success(list);
    }
}
