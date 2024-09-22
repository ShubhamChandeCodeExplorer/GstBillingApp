package com.csi.enitity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GstBill")
public class GstBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;
    @Size(min = 2,message = "Customer Should be atleast 2 charcter")
    private String custName;
    private String custAddress;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDate;
    @NotNull
    private long custContact;
    @Email(message = "Email Must be Valid")
    private String custEmailId;
    private double invoiceAmount;
}
