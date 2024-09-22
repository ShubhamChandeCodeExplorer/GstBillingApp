package com.csi.service;

import com.csi.enitity.GstBill;

import java.util.List;
import java.util.Optional;

public interface IGstBillService {

    GstBill generateBill(GstBill gstBill);

    Optional<GstBill> findBYInvoiceId(long invoiceId);

    List<GstBill> findAll();

    GstBill update(GstBill gstBill);

    void deleteById(long invoiceId);
}
