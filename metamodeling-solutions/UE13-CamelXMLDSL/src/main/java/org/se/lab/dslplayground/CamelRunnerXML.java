package org.se.lab.dslplayground;

import org.apache.camel.CamelContext;

public class CamelRunnerXML {

	public static void main(String[] args) throws Exception {
        
		CamelXMLHandler camelXMLHandler = new CamelXMLHandler();
		
		CamelContext context = camelXMLHandler.loadRouteFromXML();

        context.start();
        
        System.out.println("Camel context started.");
        
        Thread.currentThread().join();

	}
}
