package com.cjt.commo.lang;

import lombok.Data;

/**
 * @Author: yxx
 * @Date: 2020/9/7 15:46
 * @Description: *
 */
@Data
public class Result {
    private int code;//200正常，非200异常
    private Object result;
    private String msg;


    public static Result success(Object result){
        return success(200,result,"操作成功");
    }

    public static Result success(int code, Object data, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setResult(data);
        result.setMsg(msg);
        return result;
    }


    public static Result fail( String msg){
        return fail(400, null, msg);
    }

    public static Result fail( Object result,String msg){
        return fail(400, result, msg);
    }
    public static Result fail(int code, Object data, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setResult(data);
        result.setMsg(msg);
        return result;
    }
}
