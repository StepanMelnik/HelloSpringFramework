package com.sme.spring.mvc.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Range;

/**
 * Shopcart item of shop cart.
 */
public class ShopcartItem implements Serializable
{
    private static final int NINETY = 90;

    @Range(min = 1, max = NINETY, message = "Quantity must be between 1 and 90")
    private int quantity;
    private Article article;

    public ShopcartItem()
    {
    }

    public ShopcartItem(Article article)
    {
        this(0, article);
    }

    public ShopcartItem(int quantity, Article article)
    {
        this();
        this.quantity = quantity;
        this.article = article;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public Article getArticle()
    {
        return article;
    }

    public void setArticle(Article article)
    {
        this.article = article;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        ShopcartItem other = (ShopcartItem) obj;
        return new EqualsBuilder()
                .append(quantity, other.quantity)
                .append(article, other.article)
                .isEquals();
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
