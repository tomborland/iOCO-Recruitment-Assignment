package com.tom.iOCO;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//@ApiModel(description = "Details about the invoice")
@Entity
public class Invoice
{
    @Id
    @GeneratedValue
    private Integer Id;

    @Size(min=2, message = "Client must have 2 or more characters")
    @ApiModelProperty(notes = "Client must have 2 or more characters")
    private String client;

    private Long vatRate;

    private Date invoiceDate;

    public Integer getId()
    {
        return Id;
    }

    public void setId(Integer id)
    {
        Id = id;
    }

    public String getClient()
    {
        return client;
    }

    public void setClient(String client)
    {
        this.client = client;
    }

    public Long getVatRate()
    {
        return vatRate;
    }

    public void setVatRate(Long vatRate)
    {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate()
    {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getSubTotal()
    {
        return BigDecimal.valueOf(1);
    }

    public BigDecimal getVat()
    {
        return BigDecimal.valueOf(1);
    }

    public BigDecimal getTotal()
    {
        return BigDecimal.valueOf(1);
    }

}
