package com.csi.service;

import com.csi.enitity.GstBill;
import com.csi.repository.GstBillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GstBillService implements IGstBillService{
    @Autowired
    private GstBillRepository gstBillRepository;
    @Override
    public GstBill generateBill(GstBill gstBill) {
        gstBill.setInvoiceAmount(gstBill.getInvoiceAmount()+(gstBill.getInvoiceAmount()*0.18));
        log.info("After Calculation Gst Amount"+gstBill.getInvoiceAmount());
        return gstBillRepository.save(gstBill);
    }

    @Override
    public Optional<GstBill> findBYInvoiceId(long invoiceId) {
        return gstBillRepository.findById(invoiceId);
    }

    @Override
    public List<GstBill> findAll() {
        return gstBillRepository.findAll();
    }

    @Override
    public GstBill update(GstBill gstBill) {
        return gstBillRepository.save(gstBill);
    }

    @Override
    public void deleteById(long invoiceId) {
        gstBillRepository.deleteById(invoiceId);
    }
}
