package com.example.springboottransaction.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fyb
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 邮箱号码
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户角色id，指向role
     */
    private Integer roleId;

    /**
     * 1代表可以使用，0代表封禁
     */
    private Boolean isAlive;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
