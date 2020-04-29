package com.sme.spring.mvc.interceptor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import com.sme.spring.mvc.model.Shopcart;

/**
 * Unit tests of {@link SessionInterceptor}.
 */
public class SessionInterceptorTest extends Assertions
{
    private final SessionInterceptor sessionInterceptor = new SessionInterceptor();

    @Test
    void testSessionInterceptor() throws Exception
    {
        MockHttpServletResponse response = new MockHttpServletResponse();

        MockHttpSession session = new MockHttpSession();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setSession(session);

        sessionInterceptor.preHandle(request, response, new Object());

        assertEquals(new Shopcart(), session.getAttribute("shopcart"));
    }
}
