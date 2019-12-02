package com.tom.iOCO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import sun.util.calendar.LocalGregorianCalendar;

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

    @GetMapping("/invoices/string/{invoice}")
    Invoice postAddInvoice(@PathVariable String invoice)
    {
        Date date;
        String[] inv      = invoice.split(",");
        try
        {
            date = new Date(inv[3]);
        }
        catch (Exception e)
        {
            System.out.println("Changing date from "+inv[3]+" to "+new Date());
            date = new Date();
        }
        Invoice invoice1  = new Invoice(Long.parseLong(inv[0]), inv[1], Long.parseLong(inv[2]), date);
        //System.out.println("\n\n\t\t\tinvoice1 = "+invoice1.toString()+"\n\n\n");
        repository.save(invoice1);
        return invoice1;
    }
/*
    @GetMapping("/invoices/{invoice}")
    void getAddInvoice(@PathVariable Invoice invoice)
    {
        System.out.println("\n\n\n\t\t\tgettAddInvoice called\n\n\n\n\n\n\n");
        repository.save(invoice);
    }
*/
    @PutMapping("/invoices/{invoice}")
    void putAddInvoice(@PathVariable Invoice invoice)
    {
        System.out.println("\n\n\n\t\t\tputAddInvoice called\n\n\n\n\n\n\n");
        repository.save(invoice);
        //return invoice;
    }

    @GetMapping("/invoices")            // Works
    //@PutMapping("/invoices")
    List<Invoice> invoiceList ()
    {
        return repository.findAll();
    }

    @GetMapping("/invoices/{invoiceId}")    // Works
    public Invoice viewInvoice(@PathVariable Long invoiceId)
    {
        Optional<Invoice> invoiceOpt = repository.findById(invoiceId);
        Invoice invoice = invoiceOpt.orElse(new Invoice(-1L, "Does not exist", -1L, new Date()));

        return invoice;
    }
}
