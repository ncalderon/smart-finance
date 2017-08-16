package com.calderoncode.sf.importer;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.model.BankEntity;
import com.calderon.sf.data.model.TransactionEntity;
import com.calderon.sf.data.service.TransactionManagement;
import com.calderoncode.sf.importer.service.AccountServiceData;
import com.calderoncode.sf.importer.service.BankServiceData;
import com.calderoncode.sf.importer.parser.TransactionParser;
import com.calderoncode.sf.reader.Reader;
import com.calderoncode.sf.transport.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DbImporter implements Importer {

    private TransactionManagement transactionManagement;
    private BankServiceData bankServiceData;
    private AccountServiceData accountServiceData;

    public DbImporter() {
    }

    private void init()  {

    }

    @Autowired
    public void setTransactionManagement(TransactionManagement transactionManagement) {
        this.transactionManagement = transactionManagement;
    }

    @Autowired
    public void setBankServiceData(BankServiceData bankServiceData) {
        this.bankServiceData = bankServiceData;
    }

    @Autowired
    public void setAccountServiceData(AccountServiceData accountServiceData) {
        this.accountServiceData = accountServiceData;
    }

    public void doImport(Reader reader) {
        BankEntity bank = bankServiceData.getBankEntityFrom(reader.getAccount().getBank());
        AccountEntity account = accountServiceData.getAccountEntityFrom(reader.getAccount(), bank);
        List<TransactionEntity> transactions = reader.getTransactions().stream().map(x->parseTransaction(x)).collect(Collectors.toList());
        transactionManagement.save(bank, account, transactions);
    }

    private TransactionEntity parseTransaction (Transaction tran) {
        return TransactionParser.parse(tran);
    }
}
