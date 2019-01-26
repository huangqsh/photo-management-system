package top.huangqsh.business.column.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

/**
* @Description:    栏目显示位置
* @Author:         huangqsh
* @CreateDate:     2019/1/25 11:32
* @UpdateRemark:
* @Version:        1.0
*/
@Table(name = "tab_display_position")
public class DisplayPosition extends BaseEntity {
    // 位置名
    private String positionName;
    private String positionCode;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }
}
