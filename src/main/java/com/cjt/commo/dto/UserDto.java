package com.cjt.commo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: yxx
 * @Date: 2020/9/23 21:27
 * @Description: *
 */

@Data
public class UserDto implements Serializable {
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String userPassword;

    //@NotBlank(message = "名字不能为空")
    @ApiModelProperty(value = "真实名字")
    private String realName;

}
