package com.calderon.sf.exporter.parser;

import com.calderon.sf.data.model.TransactionEntity;
import com.calderoncode.sf.transport.*;

public class TransactionParser {
    public static final Transaction parse (TransactionEntity transaction) {
        return new Transaction.Builder()
                .setTranMethod(TranMethodEnum.from(transaction.getTranMethod()))
                .setTranDesc(transaction.getTranDesc())
                .setTranNum(transaction.getTranNum())
                .setTranRefNum(transaction.getTranRefNum())
                .setTranAmount(transaction.getTranAmount())
                .setTranPostDate(transaction.getTranPostDate())
                .setAccount(new Account.Builder()
                                .setBank(new Bank.Builder()
                                            .setName(transaction.getAccountByAccountId().getBankByBankId().getName())
                                        .build()
                                )
                                .setCreated(transaction.getAccountByAccountId().getCreated().toLocalDateTime())
                                .setName(transaction.getAccountByAccountId().getAccName())
                                .setNumber(transaction.getAccountByAccountId().getAccNum())
                                .setType(AccountTypeEnum.from(transaction.getAccountByAccountId().getTypeId()))
                                .build())
                .setType(TranTypeEnum.from(transaction.getTypeId()))
                .setCategory(TranCategoryEnum.from(transaction.getCategoryId()))
                .build();
    }
}
