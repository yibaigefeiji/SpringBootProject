package com.qf.springbootproject.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @ClassName User
 * @Author Ashe
 * @Date 2023/6/28 18:52
 * @Description
 */
// 必须要加这三个注解
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体类")
public class User {


    @Id //证明他这个字段是主键
    @ApiModelProperty(value = "用户ID")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
