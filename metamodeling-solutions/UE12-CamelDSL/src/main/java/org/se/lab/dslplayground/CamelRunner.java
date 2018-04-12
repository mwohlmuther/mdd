package org.se.lab.dslplayground;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelRunner {

	public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
  
		context.addRoutes(new RouteBuilder() {
            public void configure() {
            	 //from("file:///tmp/camelexample?move=processed?").log("test")
            	from("file://src/main/resources/input?move=../processed").log("test")
                .choice()
                    .when(xpath("/book/price > 30"))
                    .log("expensive Book")
                    .otherwise()
                    .log("cheap Book");
            }
        });

        context.start();
        
        System.out.println("Camel context started.");
        
        Thread.currentThread().join();

	}
}
