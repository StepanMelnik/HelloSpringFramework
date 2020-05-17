package com.sme.spring.mvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represents shop cart POJO.
 */
public class Shopcart implements Serializable
{
    private final List<ShopcartItem> shopcartItems = new ArrayList<>();

    public void add(ShopcartItem shopcartItem)
    {
        shopcartItems.add(shopcartItem);
    }

    public void remove(ShopcartItem shopcartItem)
    {
        shopcartItems.remove(shopcartItem);
    }

    public List<ShopcartItem> getShopcartItems()
    {
        return shopcartItems;
    }

    /**
     * Calculate total amount.
     * 
     * @return Returns total amount.
     */
    public BigDecimal getTotalAmount()
    {
        return shopcartItems.stream()
                .map(item -> item.getArticle().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
