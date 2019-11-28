--- copy tables to backup schema
CREATE TABLE TBL_invoices (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  client VARCHAR(250) NOT NULL,
  vatRate LONG NOT NULL,
  invoiceDate date DEFAULT 0
  );

insert into TBL_invoices ()
