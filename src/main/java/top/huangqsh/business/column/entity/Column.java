package top.huangqsh.business.column.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "tab_column")
public class Column extends BaseEntity {

    // 栏目名
    private String columnName;
    // 排序
    private Integer sort;
    // 显示位置
    private String displayPositionId;
    // 冗余字段 位置信息
    private String positionCode;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDisplayPositionId() {
        return displayPositionId;
    }

    public void setDisplayPositionId(String displayPositionId) {
        this.displayPositionId = displayPositionId;
    }

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

}
