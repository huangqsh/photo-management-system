package top.huangqsh.business.tellyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.tellyou.entity.TellYou;
import top.huangqsh.business.tellyou.service.TellYouService;
import top.huangqsh.core.base.BaseResult;

/**
* @Description:    隐藏功能接口
* @Author:         huangqsh
* @CreateDate:     2019/1/26 15:58
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping("/tellyou")
public class TellYouController {

    @Autowired
    private TellYouService tellYouService;

    /**
     *
     * @param yourName
     * @param answer
     * @return
     */
    public BaseResult<TellYou> getTellYou(String yourName, String answer){
        return null;
    }
}
