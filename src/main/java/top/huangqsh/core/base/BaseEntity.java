package top.huangqsh.core.base;

import top.huangqsh.core.utils.UuidUtil;

import javax.persistence.Id;
import java.util.Date;

public class BaseEntity {
    @Id
    private String id;
    //删除状态 0未删除，1已删除
    private Integer deleted;
    private Date createDate;

    public void init(){
        this.id = UuidUtil.getUuid36();
        this.deleted = 0;
        this.createDate = new Date();
    }

    public void init(String uuid){
        this.id = uuid;
        this.deleted = 0;
        this.createDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
