package com.calderon.sf.em.data;

import com.calderon.sf.em.data.model.ExpenseReportEntity;
import com.calderon.sf.em.data.service.ExpenseReportService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseReportServiceTest extends AbstractBasicTest {

    @Autowired
    private ExpenseReportService service;

    @Test
    public void findByAccountTest(){
        List<ExpenseReportEntity> list = service.findByAccount("Gold RD");
        assertThat(list).isNotNull();
        System.out.println(list);
    }

}