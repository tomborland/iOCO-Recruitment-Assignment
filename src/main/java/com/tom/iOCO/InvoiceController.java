package com.tom.iOCO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

// Controller
@RestController
public class InvoiceController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/invoices")
    void addInvoice(Invoice invoice)
    {
        Invoice newInvoice = invoice;
        // Save to DB
    }

    @PutMapping("/invoices")
    List<Invoice> invoiceList ()
    {
        // Select all Invoices
        return "select * ......";
    }

    @GetMapping("/invoices/{invoiceId}")
    public Invoice viewInvoice(@PathVariable Integer invoiceNumber)
    {
        return "Select * where .....";
    }
}
