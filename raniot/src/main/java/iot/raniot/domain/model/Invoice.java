package iot.raniot.domain.model;

import java.time.LocalDate;

public class Invoice {
    private Long id;
    private LocalDate invoiceDate;
    private String totalReprocess;
    private String unitPrice;
    private String unitDiscount;
    private String totalDiscount;
    private String totalInvoice;

    public Long getId() {
        return id;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getTotalReprocess() {
        return totalReprocess;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getUnitDiscount() {
        return unitDiscount;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public String getTotalInvoice() {
        return totalInvoice;
    }

    public Invoice(Long id, LocalDate invoiceDate, String totalReprocess, String unitPrice, String unitDiscount, String totalDiscount, String totalInvoice) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.totalReprocess = totalReprocess;
        this.unitPrice = unitPrice;
        this.unitDiscount = unitDiscount;
        this.totalDiscount = totalDiscount;
        this.totalInvoice = totalInvoice;
    }
}
