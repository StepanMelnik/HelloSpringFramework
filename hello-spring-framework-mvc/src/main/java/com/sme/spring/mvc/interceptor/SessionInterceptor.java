package com.sme.spring.mvc.interceptor;

import static com.sme.spring.mvc.util.OptionalConsumer.of;
import static org.springframework.web.util.WebUtils.getSessionAttribute;
import static org.springframework.web.util.WebUtils.setSessionAttribute;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sme.spring.mvc.model.Shopcart;

/**
 * Session interceptor to prepare values in the http session.
 */
public class SessionInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        of(Optional.ofNullable(getSessionAttribute(request, "shopcart"))).ifNotPresent(() -> setSessionAttribute(request, "shopcart", new Shopcart()));
        return true;
    }
}
