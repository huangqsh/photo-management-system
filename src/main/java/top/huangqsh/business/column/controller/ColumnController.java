package top.huangqsh.business.column.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.column.entity.Column;
import top.huangqsh.business.column.service.Impl.ColumnServiceImpl;
import top.huangqsh.core.base.Page;

import java.util.List;

/**
* @Description:
* @Author:         huangqsh
* @CreateDate:     2019/1/22 17:10
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private ColumnServiceImpl columnService;

    private static Logger logger = LoggerFactory.getLogger(ColumnController.class);

    @RequestMapping("/find/column/page")
    public String findColumnPage(String gridPager){
        JSONObject json = JSONObject.parseObject(gridPager);
        logger.info(json.toJSONString());
        Page<Column> page = JSONObject.toJavaObject(json,Page.class);
        List<Column> columns = columnService.findColumnPage(page.getNowPage(),page.getPageSize());
        PageInfo<Column> pageInfo = new PageInfo<>(columns);
        page = new Page<>(pageInfo);
        return JSONObject.toJSONString(page);
    }
}
