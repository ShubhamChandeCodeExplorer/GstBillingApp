package com.csi.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String userPassword;
}
