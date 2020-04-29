package com.sme.spring.mvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Unit tests of {@link ShopcartController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ShopcartControllerTest extends Assertions
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShopcartsNew() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/shopcarts/1/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("shopcartItem"))
                .andExpect(MockMvcResultMatchers.view().name("shopcart/edit"));
    }

    @Test
    void testRemoveArticle() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/shopcarts/1/2/remove"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.model().attributeExists("shopcart"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));

    }
}
