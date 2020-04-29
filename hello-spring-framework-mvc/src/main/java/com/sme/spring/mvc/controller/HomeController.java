package com.sme.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sme.spring.mvc.service.IArticleService;

/**
 * Home controller to show all available articles.
 */
@Controller
public class HomeController
{
    private final IArticleService articleService;

    public HomeController(IArticleService articleService)
    {
        this.articleService = articleService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(ModelMap model)
    {
        model.put("articles", articleService.findAll());
        return "home";
    }
}
