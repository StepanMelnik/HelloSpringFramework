package com.sme.spring.mvc.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sme.spring.mvc.model.Article;
import com.sme.spring.mvc.persistence.ArticleRepository;

/**
 * Article service implementation.
 */
@Service
public class ArticleService implements IArticleService
{
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll()
    {
        return articleRepository.findAll(Sort.by("id"));
    }

    @Override
    public Article findById(int id)
    {
        return articleRepository.findById(id);
    }
}
