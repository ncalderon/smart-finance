package com.calderon.finance;


import com.calderon.finance.util.DbTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LogManager.getLogger();
    public static void main( String[] args )
    {
        logger.info("Starting app...");
        new DbTool("jdbc:sqlite:test.db");
    }
}
