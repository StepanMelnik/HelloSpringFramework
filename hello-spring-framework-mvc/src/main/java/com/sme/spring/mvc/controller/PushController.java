package com.sme.spring.mvc.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple implementation of PushBuilder in Servlet4.
 */
@Controller
public class PushController
{
    /**
     * Creates PushBuilder in a request.
     * 
     * @param request The servlet request;
     * @return Returns string response.
     */
    @RequestMapping(path = "/push", method = RequestMethod.GET)
    public String push(HttpServletRequest request)
    {
        PushBuilder newPushBuilder = request.newPushBuilder();
        Objects.requireNonNull(newPushBuilder, "Tomcat must use a proper sll configuration with http2 protocol");

        // See example in https://github.com/StepanMelnik/Servlet4_Features
        //        newPushBuilder
        //                .path("resources/images/tomcat.png")
        //                .push();

        return "Hello push request";
    }
}
