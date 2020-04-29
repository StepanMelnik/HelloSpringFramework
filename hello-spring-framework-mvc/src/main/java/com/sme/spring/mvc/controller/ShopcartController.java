package com.sme.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sme.spring.mvc.model.Shopcart;
import com.sme.spring.mvc.model.ShopcartItem;
import com.sme.spring.mvc.service.IArticleService;

/**
 * Provides functionality to work with a shopcart.
 */
@Controller
@SessionAttributes("shopcart")
public class ShopcartController
{
    private final IArticleService articleService;

    public ShopcartController(IArticleService articleService)
    {
        this.articleService = articleService;
    }

    /**
     * Init binder.
     * 
     * @param dataBinder The instance of deta binder.
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Shopcart form.
     * 
     * @param articleId The given article id;
     * @param model The given model;
     * @return Returns view.
     */
    @GetMapping("/shopcarts/{articleId}/new")
    public String newShopcart(@PathVariable("articleId") int articleId, ModelMap model)
    {
        model.put("shopcartItem", new ShopcartItem(articleService.findById(articleId)));
        return "shopcart/edit";
    }

    /**
     * Add shopcart.
     * 
     * @param shopcartItemHolder The shopcart item holder;
     * @param bindingResult The binding result;
     * @param model The given model;
     * @return returns view.
     */
    @PostMapping("/shopcarts/add")
    public String addShopcart(@Valid ShopcartItem shopcartItemHolder, BindingResult bindingResult, ModelMap model)
    {
        if (bindingResult.hasErrors())
        {
            return "shopcart/edit";
        }

        ShopcartItem shopcartItem = new ShopcartItem(shopcartItemHolder.getQuantity(), articleService.findById(shopcartItemHolder.getArticle().getId()));
        model.put("shopcartItem", shopcartItem);

        Shopcart shopcart = (Shopcart) model.get("shopcart");
        shopcart.add(shopcartItem);

        return "shopcart/edit";
    }

    /**
     * Remove article from shopcart.
     * 
     * @param articleId The given article id;
     * @param quantity The given quantity;
     * @param model The model of view;
     * @return Returns view.
     */
    @GetMapping("/shopcarts/{articleId}/{quantity}/remove")
    public String removeArticle(@PathVariable("articleId") int articleId, @PathVariable("quantity") int quantity, ModelMap model)
    {
        Shopcart shopcart = (Shopcart) model.get("shopcart");
        shopcart.remove(new ShopcartItem(quantity, articleService.findById(articleId)));
        return "redirect:/";
    }
}
