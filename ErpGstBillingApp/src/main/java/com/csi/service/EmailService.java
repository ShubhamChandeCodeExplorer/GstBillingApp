package com.csi.service;

import com.csi.enitity.GstBill;
import com.csi.model.EmailModel;
import com.csi.repository.GstBillRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private GstBillRepository gstBillRepository;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMail(String toEmail)  {
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
        GstBill gstBill=gstBillRepository.findByCustEmailId(toEmail);
        try {
            mimeMessageHelper.setFrom(fromMail);
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject("Gst Bill Invoice");
            mimeMessageHelper.setText("\n Customer Name:"+gstBill.getCustName()+"\n"+gstBill.getCustAddress()+"\n"+gstBill.getInvoiceAmount()+"\n"+gstBill.getCustContact()+"\n"+gstBill.getInvoiceId());
            mailSender.send(mimeMessage);
            log.info("MAIL SEND SUCESSFULLY");
        }catch(MessagingException e){
            throw  new RuntimeException(e);
        }
    }
}
