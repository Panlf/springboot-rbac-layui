package com.plf.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

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
