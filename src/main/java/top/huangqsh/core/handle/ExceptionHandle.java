package top.huangqsh.core.handle;

import top.huangqsh.core.base.BaseResult;
import top.huangqsh.core.enums.ResultEnum;
import top.huangqsh.core.exception.GlobalException;
import top.huangqsh.core.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author situliang
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ResultUtil.error(globalException.getCode(), globalException.getMessage());
        } else {
            logger.error("系统异常:{}", e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),
                    ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}
