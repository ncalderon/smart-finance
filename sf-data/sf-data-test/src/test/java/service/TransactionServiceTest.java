package service;

import com.calderon.sf.data.model.TransactionEntity;
import com.calderon.sf.data.service.TransactionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionServiceTest extends AbstractBasicTest {

    @Autowired
    private TransactionService service;

    @Test
    public void findOneByAccountIdAndTranNum() throws Exception {
        TransactionEntity transaction = service.findFirstByAccountIdAndTranNum(62, "65227397089030028000025");
        System.out.println(transaction);
        assertThat(transaction).isNotNull();
    }

    @Test
    public void findByPendingStatus() throws Exception {
        List<TransactionEntity> transactions = service.findByPendingStatus();
        System.out.println(transactions);
        assertThat(transactions).isEmpty();
    }

    @Test
    public void saveTransactions() throws Exception {
        TransactionEntity transaction1 = service.findFirstByAccountIdAndTranNum(62, "65227397089030028000025");
        transaction1.setModified(parseLocalDate(LocalDate.now()));
        TransactionEntity transaction2 = service.findFirstByAccountIdAndTranNum(42, "74763947141014108294351");
        transaction2.setModified(parseLocalDate(LocalDate.now()));
        List<TransactionEntity> transactions = Arrays.asList(transaction1, transaction2);
        service.saveTransactions(transactions);
    }

    private static Timestamp parseLocalDate (LocalDate date) {
        Calendar instance = Calendar.getInstance();
        instance.set(date.getYear(), date.getMonthValue()-1, date.getDayOfMonth(), 0, 0, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return new Timestamp(instance.getTimeInMillis());
    }

}