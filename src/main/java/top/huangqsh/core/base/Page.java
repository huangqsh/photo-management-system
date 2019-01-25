package top.huangqsh.core.base;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Page<T> implements Serializable {

    private static final long serialVersionUID = 23543576568L;


    private Boolean isSuccess = Boolean.FALSE;

    /**
     * 当前页
     */
    private Integer nowPage;

    /**
     * 每页显示的记录数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 总记录数
     */
    private Long recordCount;

    /**
     * 当前结果集
     */
    private List<T> exhibitDatas;

    /**
     * 查询参数列表
     */
    private Map<String, Object> parameters;

    /**
     * init Page Object
     * @param pageInfo
     */
    public Page(PageInfo<T> pageInfo){
        this.isSuccess = Boolean.TRUE;
        this.nowPage = pageInfo.getPageNum();//设置当前页
        this.pageSize = pageInfo.getPageSize();//设置当前每页记录数
        this.pageCount = pageInfo.getPages();//设置总页数
        this.recordCount = pageInfo.getTotal();//设置总记录数
        this.exhibitDatas = pageInfo.getList();//设置查询结果集
    }

    public Page(){
        super();
    }


    /**
     * @return the isSuccess
     */
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     * @param isSuccess the isSuccess to set
     */
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * @return the nowPage
     */
    public Integer getNowPage() {
        return nowPage;
    }

    /**
     * @param nowPage the nowPage to set
     */
    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the recordCount
     */
    public Long getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * @return the exhibitDatas
     */
    public List<T> getExhibitDatas() {
        return exhibitDatas;
    }

    /**
     * @param exhibitDatas the exhibitDatas to set
     */
    public void setExhibitDatas(List<T> exhibitDatas) {
        this.exhibitDatas = exhibitDatas;
    }

    /**
     * @return the parameters
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

}
