package org.se.lab;

import java.lang.reflect.Field;

import org.se.lab.entity.User;

public interface Visitor
{
	String visitUser(User user) throws Exception;

	String visitFields(Field[] fields, User user) throws Exception;
}