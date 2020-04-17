package com.sme.spring.mvcboot;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Unit tests of {@link SimpleMvcApplication}.
 */
@WebMvcTest(SimpleMvcApplication.class)
@ContextConfiguration(classes = {SimpleMvcApplication.class})
public class SimpleMvcApplicationTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomeRequest() throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello SimpleMvcApplication Boot!")));
    }
}
