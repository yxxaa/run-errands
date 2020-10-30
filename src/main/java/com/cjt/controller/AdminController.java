package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjt.commo.dto.LoginDto;
import com.cjt.commo.dto.UserDto;
import com.cjt.commo.lang.Result;
import com.cjt.entity.Order;
import com.cjt.entity.UserInformation;
import com.cjt.service.UserInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxx
 * @since 2020-09-09
 */
@Api(value = "管理员信息", description = "管理员操作 API", position = 100, protocols = "http")
@RestController
public class AdminController {

    @Resource
    UserInformationService userInformationService;

    @ApiOperation(
            value = "管理员登录"
            //notes = "根据参数创建消息"
    )
    @PostMapping(value = "admin/login")
    public Result login(@Validated @RequestBody LoginDto loginDto){
        UserInformation userInformation = userInformationService.getOne(new QueryWrapper<UserInformation>().eq("user_name",loginDto.getUserName()).last("limit 1"));
        if (userInformation==null){
            return Result.fail("用户名不存在");
        }
        if (!userInformation.getUserPassword().equals(loginDto.getUserPassword())){
            return Result.fail("密码错误");
        }
        return Result.success(userInformation.getRealName());
    }

    @ApiOperation(
            value = "管理员列表"
    )
    @GetMapping(value = "admins")
    public Result getAdmin(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,5);
        IPage pageData = userInformationService.page(page,new QueryWrapper<UserInformation>());
        return Result.success(pageData);
    }

    // 增
    @ApiOperation(
            value = "添加管理员账号"
    )
    @PostMapping(value = "admin/add")
    public Result addAdmin(@Validated @RequestBody UserDto userDto){
        UserInformation userInformation = userInformationService.getOne(new QueryWrapper<UserInformation>()
                .eq("user_name", userDto.getUserName())
                .last("limit 1"));
        if (userInformation==null) {
            UserInformation userInformation1= new UserInformation();
            userInformation1.setUserName(userDto.getUserName());
            userInformation1.setUserPassword(userDto.getUserPassword());
            if (userDto.getRealName()!=null){
                userInformation1.setRealName(userDto.getRealName());
            }
            userInformationService.save(userInformation1);
            return Result.success(null);
        }
        return Result.fail("账号已存在！");
    }

    @ApiOperation(
            value = "删除管理员账号"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Int", paramType = "body"),
    })
    @PostMapping(value = "admin/delete")
    public Result deleteAdmin(@ApiIgnore @RequestBody Map<String,Object> user){
        Integer userId = (Integer) user.get("userId");
        UserInformation userInformation = userInformationService.getById(userId);
        if (userInformation==null){
            return Result.fail("账号已被删除！");
        }
        userInformationService.removeById(userId);
        return Result.success(null);
    }

    @ApiOperation(
            value = "更新管理员账号"
    )
    @PostMapping(value = "admin/update")
    public Result updateAdmin(@RequestBody UserInformation userInformation){
        if (userInformation.getId()==null){
            return Result.fail("失败");
        }
        UserInformation byId = userInformationService.getById(userInformation.getId());
        if (byId==null){
            return Result.fail("失败");
        }
        if (userInformation.getUserName()!=null){
            UserInformation user_name = userInformationService.getOne(new QueryWrapper<UserInformation>().eq("user_name", userInformation.getUserName()).last("limit 1"));

            if( user_name!=null && !user_name.getId().equals(userInformation.getId())){
                return Result.fail("用户名重复！");
            }
        }

        userInformationService.updateById(userInformation);
        return Result.success(null);

    }

    @ApiOperation(
            value = "搜索管理员账号"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", dataType = "String", paramType = "query"),
    })
    @GetMapping(value = "admin/search")
    public Result searchAdmin(@ApiIgnore UserInformation user){
        List<UserInformation> list = userInformationService.list(new QueryWrapper<UserInformation>()
                .eq(user.getRealName() != null, "real_name", user.getRealName())
                .eq(user.getUserName() != null, "user_name", user.getUserName())
                .last("limit 5"));
        return Result.success(list);

    }
}
