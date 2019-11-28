package com.tom.iOCO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.T;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
    Optional<Invoice> findById(Long id);
    //Invoice findOne(Long id);
    List<Invoice> findAll();
    //void insertData(Invoice invoice);
    Invoice  save(Invoice invoice);
}
