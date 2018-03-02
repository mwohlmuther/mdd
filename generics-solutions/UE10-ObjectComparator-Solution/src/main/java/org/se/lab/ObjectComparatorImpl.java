package org.se.lab;

import java.lang.annotation.Annotation;

import org.se.lab.entities.Animal;

public class ObjectComparatorImpl implements ObjectComparator {

	@Override
	public String findDifferences(Animal a1, Animal a2) {
		Class<? extends Animal> a1Class = a1.getClass();
		Class<? extends Animal> a2Class = a2.getClass();
		
		StringBuffer sb = new StringBuffer();
		
		String a1Name = a1Class.getSimpleName();
		String a2Name = a2Class.getSimpleName();
		
		int a1MethodCount = a1Class.getDeclaredMethods().length;
		int a2MethodCount = a2Class.getDeclaredMethods().length;
		
		int a1ConstructorCount = a1Class.getDeclaredConstructors().length;
		int a2ConstructorCount = a2Class.getDeclaredConstructors().length;
		
		// Annotation comparison in two directions
		for (Annotation annotation : a1Class.getAnnotations()) {
			if (a2Class.getAnnotation(annotation.annotationType()) == null){
				sb.append("Annotation only in ").append(a1Name).append(": ").append(annotation.annotationType().getSimpleName()).append("\n");
			}
		}
		for (Annotation annotation : a2Class.getAnnotations()) {
			if (a1Class.getAnnotation(annotation.annotationType()) == null){
				sb.append("Annotation only in ").append(a2Name).append(": ").append(annotation.annotationType().getSimpleName()).append("\n");
			}
		}

		// Method count comparison
		if (a1MethodCount != a2MethodCount) {
			sb.append("Methods: ");
			sb.append(a1Name).append(":").append(a1MethodCount).append("  ");
			sb.append(a2Name).append(":").append(a2MethodCount).append("\n");
		}
		
		// Annotation count comparison
		if (a1ConstructorCount != a2ConstructorCount) {
			sb.append("Constructors: ");
			sb.append(a1Name).append(":").append(a1ConstructorCount).append("  ");
			sb.append(a2Name).append(":").append(a2ConstructorCount).append("\n");
		}
		
		
		if (sb.length() == 0) {
			return "No Differences found";
		}
		
		return sb.toString();
	}

}
