package com.calderon.sf.exporter.test;

import com.calderon.sf.data.service.BankService;

import com.calderon.sf.exporter.DbExporter;
import com.calderon.sf.exporter.Exporter;
import com.calderoncode.sf.writer.Writer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExporterTest extends AbstractBasicTest {
    @Autowired
    private Exporter exporter;
    @Autowired
    private Writer writer;
    /*@Autowired*/
    /*private ExpenseReportService service;*/
    /*private BankService service;*/
    @Test
    public void doExport(){
        /*assertThat(writer).isNotNull();
        assertThat(exporter).isNotNull();
        assertThat(((DbExporter)exporter).getTransactionService()).isNotNull();*/
        /*List<ExpenseReportEntity> list = service.findByAccount("Gold RD");
        assertThat(list).isNotNull();
        System.out.println(list);*/
        /*assertThat(service.findFirstByName("Banco Popular Dominicano")).isNotNull();*/
        assertThat(exporter).isNotNull();
        exporter.doExport(writer);
    }
}
