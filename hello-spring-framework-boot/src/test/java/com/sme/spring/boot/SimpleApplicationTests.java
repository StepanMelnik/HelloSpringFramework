package com.sme.spring.boot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit tests of {@link SimpleApplication}.
 */
@SpringBootTest(classes = SimpleApplication.class)
public class SimpleApplicationTests
{
    @Autowired
    private SimpleApplicationEventData simpleApplicationEventData;

    @Test
    public void testContextCreated() throws Exception
    {
        assertTrue(simpleApplicationEventData.getStart() > 0, "Expects initialized start property");
        assertTrue(simpleApplicationEventData.getFinish() > 0, "Expects initialized finish property");
        assertTrue(simpleApplicationEventData.getFinish() > simpleApplicationEventData.getStart());
    }
}
