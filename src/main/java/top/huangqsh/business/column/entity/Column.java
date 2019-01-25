package top.huangqsh.business.column.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "tab_column")
public class Column extends BaseEntity {

    private String columnName;
    // 排序
    private Integer sort;
    // 是否显示
    private Integer display;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}
