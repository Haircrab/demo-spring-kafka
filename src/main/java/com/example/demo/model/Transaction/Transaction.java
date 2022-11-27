package com.example.demo.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String uuid;
    private Date valueDate;
    private String amountWithCurr;
    private String iban;
    private String description;
}
