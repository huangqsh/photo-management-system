package top.huangqsh.core.base;

import top.huangqsh.core.utils.UuidUtil;

import javax.persistence.Id;
import java.util.Date;

public class BaseEntity {
    @Id
    private String id;
    //删除状态 0未删除，1已删除
    private Integer deleted;
    //禁用状态 0启用 1禁用
    private Integer disabled;
    private Date createDate;

    public void init(){
        this.id = UuidUtil.getUuid36();
        this.deleted = 0;
        this.disabled = 0;
        this.createDate = new Date();
    }

    public void init(String uuid){
        this.id = uuid;
        this.deleted = 0;
        this.disabled = 0;
        this.createDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
