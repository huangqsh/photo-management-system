package top.huangqsh.business.column.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.column.entity.Column;
import top.huangqsh.business.column.entity.DisplayPosition;
import top.huangqsh.business.column.service.Impl.ColumnServiceImpl;
import top.huangqsh.core.base.BaseResult;
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

    /**
     * 查询显示位置（为了减少编码，对位置的crud直接在数据库中手动完成，因为一个项目中显示位置信息不会很多也不会变动）
     * @return
     */
    @RequestMapping("/find/display/position")
    public BaseResult<List<DisplayPosition>> findDisplayPosition(){
        return null;
    }

    /**
     * 分页查询栏目
     * @param gridPager
     * @return
     */
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

    /**
     * 通过位置信息查询栏目
     * @param positionCode
     * @return
     */
    @RequestMapping("/find/column/list")
    public BaseResult<List<Column>> findColumnList(String positionCode){
        return null;
    }

    /**
     * 添加栏目
     * @param column
     * @return
     */
    @RequestMapping("/find/column")
    public BaseResult<String> addColumn(Column column){
        return null;
    }

    /**
     * 修改栏目
     * @param column
     * @return
     */
    @RequestMapping("/update/column")
    public BaseResult<String> updateColumn(Column column){
        return null;
    }

    /**
     * 禁用栏目
     * @param id
     * @return
     */
    @RequestMapping("/disable/column")
    public BaseResult<String> disableColumn(String id){
        return null;
    }

}
