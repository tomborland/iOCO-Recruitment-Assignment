package com.tom.iOCO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@ApiModel(description = "Details about the Item")
@Entity
public class LineItem
{
    @Id
    @GeneratedValue
    private Long id;

    private Long quality;

    private String description;

    private BigDecimal unitPrice;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getQuality()
    {
        return quality;
    }

    public void setQuality(Long quality)
    {
        this.quality = quality;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    BigDecimal getLineItemTotal()
    {

    }
}
