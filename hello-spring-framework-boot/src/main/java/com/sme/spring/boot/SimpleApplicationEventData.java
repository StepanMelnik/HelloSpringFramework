package com.sme.spring.boot;

import org.springframework.stereotype.Component;

/**
 * Simple sprint component to be registered in Spring IOC.
 */
@Component
public class SimpleApplicationEventData
{
    private long start;
    private long finish;

    public long getStart()
    {
        return start;
    }

    public void setStart(long start)
    {
        this.start = start;
    }

    public long getFinish()
    {
        return finish;
    }

    public void setFinish(long finish)
    {
        this.finish = finish;
    }
}
