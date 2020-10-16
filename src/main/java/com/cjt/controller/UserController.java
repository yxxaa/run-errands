package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjt.commo.dto.LoginDto;
import com.cjt.commo.dto.UserDto;
import com.cjt.commo.lang.Result;
import com.cjt.entity.User;
import com.cjt.entity.UserInformation;
import com.cjt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxx
 * @since 2020-09-25
 */
@Api(value = "用户信息", description = "用户操作 API", position = 100, protocols = "http")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(
            value = "用户登录"
            //notes = "根据参数创建消息"
    )
    @PostMapping(value = "user/login")
    public Result login(@Validated @RequestBody LoginDto loginDto){
        User user = userService.getOne(new QueryWrapper<User>().eq("user_name",loginDto.getUserName()).last("limit 1"));
        if (user==null){
            return Result.fail("用户名不存在");
        }
        if (!user.getUserPassword().equals(loginDto.getUserPassword())){
            return Result.fail("密码错误");
        }
        return Result.success(user.getRealName());
    }

    @ApiOperation(
            value = "用户列表"
    )
    @GetMapping(value = "users")
    public Result getUser(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,5);
        IPage pageData = userService.page(page,new QueryWrapper<User>());
        return Result.success(pageData);
    }
    // 增
    @ApiOperation(
            value = "添加用户账号"
    )
    @PostMapping(value = "user/add")
    public Result addUser(@Validated @RequestBody User user){
        User getUser = userService.getOne(new QueryWrapper<User>()
                .eq("user_name", user.getUserName())
                .last("limit 1"));
        if (getUser==null) {
            userService.save(user);
            return Result.success(null);
        }
        return Result.fail("账号已存在！");
    }

    @ApiOperation(
            value = "删除用户账号"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer", paramType = "body"),
    })
    @PostMapping(value = "user/delete")
    public Result deleteUser(@ApiIgnore @RequestBody Map<String,Object> user){
        Integer userId = (Integer) user.get("userId");
        User getUser = userService.getById(userId);
        if (getUser==null){
            return Result.fail("账号已被删除！");
        }
        userService.removeById(userId);
        return Result.success(null);
    }

    @ApiOperation(
            value = "更新用户账号"
    )

    @PostMapping(value = "user/update")
    public Result updateUser(@RequestBody User user){
        if (user.getId()==null){
            return Result.fail("失败");
        }
        User byId = userService.getById(user.getId());
        if (byId==null){
            return Result.fail("失败");
        }
        if (user.getUserName()!=null){
            User user_name = userService.getOne(new QueryWrapper<User>().eq("user_name", user.getUserName()).last("limit 1"));

            if( user_name!=null && !user_name.getId().equals(user.getId())){
                return Result.fail("用户名重复！");
            }
        }

        userService.updateById(user);
        return Result.success(null);

    }

    @ApiOperation(
            value = "搜索用户账号"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "真实姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "studentNumber", value = "学号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "major", value = "专业", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phoneNumber", value = "电话", dataType = "String", paramType = "query"),
    })
    @GetMapping(value = "user/search")
    public Result searchUser(@ApiIgnore User user){
        List<User> list = userService.list(new QueryWrapper<User>()
                .eq(user.getRealName() != null, "real_name", user.getRealName())
                .eq(user.getUserName() != null, "user_name", user.getUserName())
                .eq(user.getMajor()!=null,"major",user.getMajor())
                .eq(user.getPhoneNumber()!=null,"phone_number",user.getPhoneNumber())
                .eq(user.getStudentNumber()!=null,"student_number",user.getStudentNumber())
                .last("limit 5"));
        return Result.success(list);
    }

}
