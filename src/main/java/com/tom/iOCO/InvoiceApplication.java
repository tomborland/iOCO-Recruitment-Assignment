package com.tom.iOCO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

//import brave.sampler.Sampler;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;

@SpringBootApplication
public class InvoiceApplication
{
    public static void main(String[] args) throws Exception
    {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/invoiceDB", "sa", "");
        SpringApplication.run(InvoiceApplication.class, args);
        conn.close();
    }

}
