package com.sme.spring.boot;

import static org.junit.Assert.assertTrue;

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
        assertTrue("Expects initialized start property", simpleApplicationEventData.getStart() > 0);
        assertTrue("Expects initialized finish property", simpleApplicationEventData.getFinish() > 0);
        assertTrue("", simpleApplicationEventData.getFinish() > simpleApplicationEventData.getStart());
    }
}
