package com.calderon.finance.finance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        com.calderon.finance.App app = new com.calderon.finance.App();
        app.init();

    }

    public static void init() {
        (new Importer()).doImport();
    }
}
