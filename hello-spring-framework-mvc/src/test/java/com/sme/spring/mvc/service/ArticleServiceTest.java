package com.sme.spring.mvc.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import com.sme.spring.mvc.model.Article;
import com.sme.spring.mvc.persistence.ArticleRepository;

/**
 * Unit tests of {@link ArticleService}.
 */
public class ArticleServiceTest extends Assertions
{
    private IArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        articleService = new ArticleService(articleRepository);
        mockWhens();
    }

    private void mockWhens()
    {
        when(articleRepository.findAll(Sort.by("id"))).thenReturn(Arrays.asList(new Article()));
        when(articleRepository.findById(1)).thenReturn(new Article());
    }

    @Test
    public void testFindAll() throws Exception
    {
        List<Article> articles = articleService.findAll();
        assertEquals(Arrays.asList(new Article()), articles);
    }

    @Test
    public void testFindById() throws Exception
    {
        Article article = articleService.findById(1);
        assertEquals(new Article(), article);
    }
}
