package top.huangqsh.business.column.service.Impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.huangqsh.business.column.dao.ColumnDao;
import top.huangqsh.business.column.entity.Column;
import top.huangqsh.business.column.service.ColumnService;

import java.util.List;

/**
* @Description:
* @Author:         huangqsh
* @CreateDate:     2019/1/22 17:08
* @UpdateRemark:
* @Version:        1.0
*/
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    private ColumnDao columnDao;

    @Override
    public List<Column> findColumnPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Column> columns = columnDao.selectAll();
        return columns;
    }
}
