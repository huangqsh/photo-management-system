package top.huangqsh.business.article.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.huangqsh.business.article.dao.ArticleDao;
import top.huangqsh.business.article.service.ArticleService;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;


}
