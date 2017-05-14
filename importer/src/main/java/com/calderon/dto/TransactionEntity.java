package com.calderon.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Nathaniel on 1/3/2017.
 */
public class TransactionEntity {
    private int transactionNumber;
    private int accountNumber;
    private LocalDateTime created;
    private String transactionType;
    private BigDecimal amount;
    private String reference;
    private String note;
    private String tag;
    private String file;
    private LocalDateTime processed;


}
