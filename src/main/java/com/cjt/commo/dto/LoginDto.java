package com.cjt.commo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: yxx
 * @Date: 2020/9/9 20:46
 * @Description: *
 */
@Data
public class LoginDto implements Serializable {
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    private String userPassword;
}
