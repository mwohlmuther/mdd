package org.se.lab;

import java.lang.reflect.Method;

public interface EntityValidator
{
	public boolean validateEntity(Class<? extends Entity> clazz) throws NoSuchFieldException, SecurityException;
	public boolean checkMethodInfos(Method method);
}