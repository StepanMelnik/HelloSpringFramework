package com.sme.spring.mvc.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sme.spring.mvc.model.Article;

/**
 * Article service.
 */
public interface IArticleService
{
    /**
     * Fetch all articles.
     * 
     * @return Returns a list of articles.
     */
    List<Article> findAll();

    /**
     * Fund article by id.
     * 
     * @param id The given article id;
     * @return Returns an article by id.
     */
    Article findById(@Param("id") int id);
}
