package service;

import com.calderon.sf.data.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)*/
public class AccountServiceTest extends AbstractBasicTest{

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindOneByAccNumAndAccName() throws Exception {
        assertThat(accountService.findOneByAccNumAndAccName("1928","Gold RD")).isNotNull();
    }

}