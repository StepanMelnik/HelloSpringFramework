package com.sme.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.sme.spring.mvc.model.Article;
import com.sme.spring.mvc.service.IArticleService;

/**
 * Controller with asynchronous processing supported by Servlet 3.0.
 */
@Controller
@RequestMapping("/emitter")
public class ResponseBodyEmitterController
{
    private static final int ARTICLES_STREAM_TIMEOUT = 100;
    private static final int NUMBERS_STREAM_TIMEOUT = 10;
    private static final int MAX_NUMBERS = 1000;

    private final TaskExecutor taskExecutor;
    private final IArticleService articleService;

    public ResponseBodyEmitterController(TaskExecutor taskExecutor, IArticleService articleService)
    {
        this.taskExecutor = taskExecutor;
        this.articleService = articleService;
    }

    /**
     * Get all articles in asynchronous mode.
     * 
     * @return Returns artiles.
     */
    @GetMapping("/articles")
    public ResponseEntity<ResponseBodyEmitter> find()
    {
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        taskExecutor.execute(() ->
        {
            List<Article> articles = articleService.findAll();

            List<Article> moreArticles = new ArrayList<>();
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);
            moreArticles.addAll(articles);

            moreArticles.stream().forEach(article ->
            {
                try
                {
                    emitter.send(article, MediaType.APPLICATION_JSON);
                    TimeUnit.MILLISECONDS.sleep(ARTICLES_STREAM_TIMEOUT);
                }
                catch (Exception e)
                {
                    emitter.completeWithError(e);
                }
            });

            emitter.complete();
        });

        return ResponseEntity.status(HttpStatus.OK)
                .header("Custom-Header", "ResponseBodyEmitter to fetch all articles")
                .body(emitter);
    }

    /**
     * Generates numbers to prepare response body for demonstration.
     * 
     * @return Returns response body emmitter.
     */
    @GetMapping("/numbers")
    public ResponseBodyEmitter numbers()
    {
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() ->
        {
            for (int i = 0; i < MAX_NUMBERS; i++)
            {
                try
                {
                    emitter.send(i + " - ", MediaType.TEXT_PLAIN);
                    TimeUnit.MILLISECONDS.sleep(NUMBERS_STREAM_TIMEOUT);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
    }
}
