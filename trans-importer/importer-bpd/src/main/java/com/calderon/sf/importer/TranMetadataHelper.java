package com.calderon.sf.importer;

import com.calderon.sf.commons.persistence.enums.AccountStatusEnum;
import com.calderon.sf.persistence.dao.AccountDAO;
import com.calderon.sf.persistence.dao.BankDAO;
import com.calderon.sf.persistence.dto.*;
import com.calderon.sf.reader.TranMetadata;

import java.math.BigDecimal;

/**
 * Created by Nathaniel on 6/10/2017.
 */
public class TranMetadataHelper {

    private TranMetadata tranMetadata;
    public TranMetadataHelper(TranMetadata tranMetadata) {
        this.tranMetadata = tranMetadata;
    }

    public AccountEntity getAccount () {
        AccountEntity accountEntity = AccountDAO.getAccountByAccNum(tranMetadata.getAccountNumber());
        if (null == accountEntity)
            accountEntity = createAccount();
        return accountEntity;
    }

    private AccountEntity createAccount() {
        BankEntity bank = getBank();
        AccountEntity account = new AccountEntity();
        account.setBankId(bank.getId());
        account.setTypeId(tranMetadata.getAccountType().id());
        account.setAccName(tranMetadata.getAccountName());
        account.setAccDescription(tranMetadata.getAccountName());
        account.setAccNum(tranMetadata.getAccountNumber());
        account.setAccBalance(new BigDecimal(0));
        account.setStatusId(AccountStatusEnum.ACTIVE.id());
        //AccountDAO.saveOrUpdate(account);
        return account;
    }
    private BankEntity getBank(){
        BankEntity bank = BankDAO.getBankByName(tranMetadata.getBankName());
        if (null == bank)
            bank = createBank();
        return bank;
    }

    private BankEntity createBank () {
        BankEntity bank = new BankEntity();
        bank.setName(tranMetadata.getBankName());
        bank.setDescription(tranMetadata.getBankName());
        //BankDAO.saveOrUpdate(bank);
        return bank;
    }

}
