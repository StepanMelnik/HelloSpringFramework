package com.sme.spring.mvc.persistence;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sme.spring.mvc.model.Article;

/**
 * Article JPA repository.
 */
public interface ArticleRepository extends Repository<Article, Integer>
{
    /**
     * Find {@link Article} by id.
     * 
     * @param id The id of article;
     * @return Returns an article by id.
     */
    @Transactional(readOnly = true)
    Article findById(@Param("id") int id);

    /**
     * Fetch all articles in the system. TODO Always use pagination!
     * 
     * @return Returns list of articles.
     */
    @Transactional(readOnly = true)
    List<Article> findAll(Sort sort);
}
