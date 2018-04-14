package org.se.lab.dslplayground;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RoutesDefinition;

public class CamelXMLHandler {
	public CamelContext loadRouteFromXML() throws Exception {
		CamelContext context = new DefaultCamelContext();
		// load route from XML and add them to the existing camel context
		InputStream is = new FileInputStream("src/main/resources/camelRoute.xml");
		RoutesDefinition routes = context.loadRoutesDefinition(is);
		context.addRouteDefinitions(routes.getRoutes());
		return context;
	}
}
