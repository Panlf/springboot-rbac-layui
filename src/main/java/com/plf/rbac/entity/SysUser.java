package com.plf.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Panlf
 * @since 2020-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private String birthday;

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
