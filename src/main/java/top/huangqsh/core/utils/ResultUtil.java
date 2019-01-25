package top.huangqsh.core.utils;

import top.huangqsh.core.base.BaseResult;
import top.huangqsh.core.enums.ResultEnum;

import java.io.Serializable;

/**
* @Description:    
* @Author:         huangqsh
* @CreateDate:     2019/1/23 9:56
* @UpdateRemark:   
* @Version:        1.0
*/
public class ResultUtil implements Serializable {

    public static BaseResult success(Object object){
        BaseResult result = new BaseResult();
        result.setCode(ResultEnum.OPERATION_SUCCESS.getCode());
        result.setMsg(ResultEnum.OPERATION_SUCCESS.getMsg());
        result.setData(object);

        return result;
    }


    public static BaseResult success(){
        return success(null);
    }

    public static BaseResult error(Integer code, String msg){
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }



}
