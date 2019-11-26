package com.tom.iOCO;

import java.sql.Connection;
import java.sql.DriverManager;
//import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.SpringVersion;

public class MainClass
{
    public static void main(String[] args) throws Exception
    {
        Connection conn = DriverManager.getConnection("jdbc:h2:~/invoiceDB", "sa", "");
        SpringApplication.run(MainClass.class, args);
        conn.close();
    }

}
