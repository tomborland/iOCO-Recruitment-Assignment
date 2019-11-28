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
    private Long id;

    //@Size(min=2, message = "Client must have 2 or more characters")
    //@ApiModelProperty(notes = "Client must have 2 or more characters")
    private String client;

    private Long vatRate;

    private Date invoiceDate;

    public Invoice(Long id, String client, Long vatRate, Date invoiceDate)
    {
        this.id          = id;
        this.client      = client;
        this.vatRate     = vatRate;
        this.invoiceDate = invoiceDate;
    }

    public Invoice()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
    } // fix

    public BigDecimal getVat()
    {
        return BigDecimal.valueOf(1);
    } // Fix

    public BigDecimal getTotal()
    {
        return BigDecimal.valueOf(1);
    } // Fix

    @Override
    public String toString()
    {
        return "Invoice{" +
               "id=" + id +
               ", client='" + client + '\'' +
               ", vatRate=" + vatRate +
               ", invoiceDate=" + invoiceDate +
               '}';
    }
}
