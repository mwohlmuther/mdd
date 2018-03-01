package org.se.lab;

import java.lang.reflect.Method;

public class EntityValidatorImpl implements EntityValidator {

	@Override
	public boolean validateEntity(Class<? extends Entity> clazz) throws NoSuchFieldException, SecurityException {
		clazz.getDeclaredField("id");
		
		Method[] methods = clazz.getDeclaredMethods();
		
		for (Method method : methods) {
			if (!checkMethodInfos(method)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkMethodInfos(Method method) {
		
		if (method.getName().equals("getAuditInfo")) {
			return method.isAnnotationPresent(Auditinformation.class);
		}
		
		return true;
	}

}
