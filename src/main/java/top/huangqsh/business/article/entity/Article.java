package top.huangqsh.business.article.entity;

import top.huangqsh.core.base.BaseEntity;

import javax.persistence.Table;

@Table(name = "tab_article")
public class Article extends BaseEntity {
    // 标题
    private String title;
    // 作者
    private String author;
    // 简介
    private String overview;
    // 内容
    private String content;
    // 热度
    private Integer hot;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}
