package com.rong.entity;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * @title: User
 * @projectName supermarket
 * @description: TODO
 * @author 荣兵强
 * @date 2022/1/2412:01
 */
@Data
@Entity
@Table(name = "t_user")
public class User extends BaseEntity implements Serializable {
    /**
     * 用户id
     */
    @Id
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 性别:0-女，1-男
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 日志-创建人
     */
    private String createdUser;

    /**
     * 日志-创建时间
     */
    private Date createdTime;

    /**
     * 日志-最后修改执行人
     */
    @Column(name = "modified_user")
    private String modifiedUser;

    /**
     * 日志-最后修改时间
     */
    private Date modifiedTime;

    /**
     * @Author 荣兵强
     * @Description //TODO
     * @Date
     * @Param
     * @return
     **/
    private Integer admin;


}