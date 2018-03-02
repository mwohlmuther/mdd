package org.se.lab;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class XMLGeneratorImpl implements XMLGenerator {

	@Override
	public String generateXML(Class<?> clazz) {
		
		StringBuilder sb = new StringBuilder("<package name=\"");
		sb.append(clazz.getPackage().getName()).append("\">\n");
		sb.append("  <class name=\"").append(clazz.getSimpleName()).append("\">\n");
		
		for (Method method : clazz.getDeclaredMethods()) {
			sb.append("  ").append(generateMethodInformation(method)).append("\n");
		}
		
		sb.append("</class>\n");
		sb.append("</package>");
		return sb.toString();
	}
	
	private String generateMethodInformation(Method method) {
		StringBuilder methodSb = new StringBuilder("<method name=\"");
		methodSb.append(method.getName()).append("\">\n");
		
		for (Parameter param : method.getParameters()) {
			methodSb.append("    <param ").append("type=\"").append(param.getType().getName()).append("\">\n");
		}
		
		methodSb.append("  </method>");
		return methodSb.toString();
	}

}
