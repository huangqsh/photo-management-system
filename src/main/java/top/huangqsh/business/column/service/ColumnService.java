package top.huangqsh.business.column.service;

import top.huangqsh.business.column.entity.Column;

import java.util.List;

public interface ColumnService {
    List<Column> findColumnPage(int currentPage,int pageSize);
}
