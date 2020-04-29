package com.sme.spring.mvc.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.sme.spring.mvc.util.PojoGenericBuilder;

/**
 * Unit tests of {@link Shopcart}.
 */
public class ShopcartTest extends APojoTest<Shopcart>
{
    @Test
    void testTotalAmount() throws Exception
    {
        Shopcart shopcart = new Shopcart();
        shopcart.add(new PojoGenericBuilder<>(ShopcartItem::new)
                .with(ShopcartItem::setQuantity, 1)
                .with(ShopcartItem::setArticle, new PojoGenericBuilder<>(Article::new)
                        .with(Article::setPrice, new BigDecimal(10.01))
                        .build())
                .build());
        shopcart.add(new PojoGenericBuilder<>(ShopcartItem::new)
                .with(ShopcartItem::setQuantity, 2)
                .with(ShopcartItem::setArticle, new PojoGenericBuilder<>(Article::new)
                        .with(Article::setPrice, new BigDecimal(5.00))
                        .build())
                .build());

        assertEquals(new BigDecimal(20.01).setScale(2, BigDecimal.ROUND_HALF_UP), shopcart.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP), "Expects a proper total amount calculation");
    }
}
