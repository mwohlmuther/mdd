package org.se.lab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EntityVisitorImpl implements EntityVisitor {

	@Override
	public String visitEntity(Class<?> clazz) {
		StringBuffer sb = new StringBuffer();

		sb.append(clazz.getSimpleName());
		sb.append("{ ");

		for (Field field : clazz.getDeclaredFields()) {
			sb.append(visitProperty(field));
		}

		sb.append("}");
		return sb.toString();
	}

	@Override
	public String visitProperty(Field field) {
		StringBuffer sb = new StringBuffer();
		sb.append(field.getName()).append(":");
		sb.append(field.getType().getSimpleName());

		sb.append(visitAnnotations(field));

		sb.append(" ");
		return sb.toString();
	}

	@Override
	public String visitAnnotations(Field field) {
		Annotation[] annotations = field.getDeclaredAnnotations();

		int annotationsToCome = annotations.length;
		if (annotationsToCome < 1) {
			return "";
		}

		StringBuffer sb = new StringBuffer("[");
		for (Annotation anno : annotations) {
			sb.append(anno.annotationType().getSimpleName());
			annotationsToCome--;

			if (annotationsToCome > 0) {
				sb.append(",");
			}

		}
		sb.append("]");
		return sb.toString();
	}

}
