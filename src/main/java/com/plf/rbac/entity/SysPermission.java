package com.plf.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型  1 菜单 2 按钮  3 访问接口
     */
    private Integer type;

    /**
     * 访问地址
     */
    private String path;

    /**
     * 父ID
     */
    private int parentId;

    /**
     * 删除标志位 默认0， 1代表已删除
     */
    private Integer flag;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;


}
