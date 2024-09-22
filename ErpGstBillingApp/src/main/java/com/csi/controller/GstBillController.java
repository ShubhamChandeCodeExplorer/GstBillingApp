package com.csi.controller;

import com.csi.enitity.GstBill;
import com.csi.exception.RecordNotFoundException;
import com.csi.service.IGstBillService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

@RestController
@RequestMapping("/v1/gst")
@Tag(name = "GST Billing", description = "APIS Of GST Bill Controller")
@SecurityRequirement(name = "Bearer Auth")
@Slf4j
public class GstBillController {
    @Autowired
    private IGstBillService billService;

    @PostMapping("/generatebill")
    public ResponseEntity<GstBill> generateBill(@Valid @RequestBody GstBill gstBill){
        log.info("Generating invoice for the customer"+gstBill.getCustName());
        return new ResponseEntity<>(billService.generateBill(gstBill), HttpStatus.CREATED);
    }

    @GetMapping("/findbyinvoiceid/{invoiceId}")
    public ResponseEntity<Optional<GstBill>> generateBill(@PathVariable long invoiceId){
        return new ResponseEntity<>(billService.findBYInvoiceId(invoiceId), HttpStatus.OK);
    }

    @GetMapping("/findallinvoices")
    public ResponseEntity<List<GstBill>> findAllInvoice(){
        return new ResponseEntity<>(billService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/updateinvoice/{invoiceId}")
    public ResponseEntity<GstBill> updateInvoice(@PathVariable long invoiceId,@Valid @RequestBody GstBill gstBill){
        GstBill gstBill1=billService.findBYInvoiceId(invoiceId).orElseThrow(()->new RecordNotFoundException("Bill Id Dosent Exists"));
        gstBill1.setCustAddress(gstBill.getCustAddress());
        gstBill1.setInvoiceDate(gstBill.getInvoiceDate());
        gstBill1.setCustContact(gstBill.getCustContact());
        gstBill1.setCustEmailId(gstBill.getCustEmailId());
        gstBill1.setInvoiceAmount(gstBill.getInvoiceAmount());
        gstBill1.setCustName(gstBill.getCustName());
        return new ResponseEntity<>(billService.update(gstBill1),HttpStatus.OK);
    }

    @DeleteMapping("/deletebyinvoiceid/{invoiceId}")
    public ResponseEntity<String> deleteInviceById(@PathVariable long invoiceId){
        billService.deleteById(invoiceId);
        return new ResponseEntity<>("Data Deleted Sucessfully",HttpStatus.OK);
    }
}
