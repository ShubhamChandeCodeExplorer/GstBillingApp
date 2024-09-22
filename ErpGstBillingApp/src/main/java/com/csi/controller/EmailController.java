package com.csi.controller;

import com.csi.service.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/gst")
@Tag(name = "GST Billing", description = "APIS Of GST Bill Controller")
@SecurityRequirement(name = "Bearer Auth")
@Slf4j
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail/{toEmail}")
    public ResponseEntity<String> sendEmail(@PathVariable String toEmail){
        emailService.sendMail(toEmail);
        return new ResponseEntity<>("Email Sent Sucessfully", HttpStatus.OK);
    }
}
