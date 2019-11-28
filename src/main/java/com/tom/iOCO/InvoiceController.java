package com.tom.iOCO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// Controller
@RestController
public class InvoiceController
{
    @Autowired
    private Environment env;

    @Autowired
    private InvoiceRepository repository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/invoices/{invoice}")
    void addInvoice(@PathVariable String invoice)
    {
        String[] inv      = invoice.split(",");
        Invoice  invoice1 = new Invoice(Long.parseLong(inv[0]), inv[1], Long.parseLong(inv[2]), new Date(inv[2]));
        repository.save(invoice1);
    }

    @PostMapping("/invoices/{invoice}")
    void addInvoice(@PathVariable Invoice invoice)
    {
        repository.save(invoice);
    }

    @PutMapping("/invoices")
    List<Invoice> invoiceList ()
    {
        return repository.findAll();
    }

    @GetMapping("/invoices/{invoiceId}")
    public Invoice viewInvoice(@PathVariable Long invoiceId)
    {
        Optional<Invoice> invoiceOpt = repository.findById(invoiceId);
        Invoice invoice = invoiceOpt.orElse(new Invoice(-1L, "Does not exist", -1L, new Date()));

        return invoice;
    }
}
