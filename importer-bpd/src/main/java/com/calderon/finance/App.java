package com.calderon.finance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.init();

    }

    public static void init() {
        (new Importer()).doImport();
    }
}
