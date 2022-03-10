package com.rong.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: BaseEntity
 * @projectName supermarket
 * @description: TODO
 * @author 荣兵强
 * @date 2022/1/2411:27
 */
//做为实体类的基础类
@Data
public class BaseEntity implements Serializable {
    private String createdUser; //'日志-创建人',
    private Date createdTime; // '日志-创建时间',
    private String modifiedUser; //'日志-最后修改执行人',
    private Date modifiedTime; // '日志-最后修改时间',
}
