package top.huangqsh.business.article.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huangqsh.business.article.dto.ArticleSimpleDto;
import top.huangqsh.business.article.entity.Article;
import top.huangqsh.business.article.service.ArticleService;
import top.huangqsh.core.base.BaseResult;
import top.huangqsh.core.base.Page;

/**
* @Description:    文章controller
* @Author:         huangqsh
* @CreateDate:     2019/1/26 10:36
* @UpdateRemark:
* @Version:        1.0
*/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    /**
     * 分页查询文章列表
     * @param gridPager
     * @return
     */
    @RequestMapping("/find/article/page")
    public String findArticlePage(String gridPager){
        JSONObject json = JSONObject.parseObject(gridPager);
        logger.info(json.toJSONString());
        Page<ArticleSimpleDto> page = JSONObject.toJavaObject(json, Page.class);
        return  null;
    }

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    @RequestMapping("/get/article")
    public BaseResult<Article> getArticle(String id){
        return  null;
    }

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    @RequestMapping("/disable/article")
    public BaseResult<String> disableArticle(String id){
        return  null;
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @RequestMapping("/update/article")
    public BaseResult<String> updateArticle(Article article){
        return  null;
    }

}
