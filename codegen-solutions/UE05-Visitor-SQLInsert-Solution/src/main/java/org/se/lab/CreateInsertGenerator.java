package org.se.lab;

import java.lang.reflect.Field;

import org.se.lab.entity.Column;
import org.se.lab.entity.Entity;
import org.se.lab.entity.User;


public class CreateInsertGenerator 
    implements Visitor
{

	@Override
	public String visitUser(User user) throws Exception {

		StringBuffer insertStatement = new StringBuffer("INSERT INTO ");

		Entity[] entityAnnotations = user.getClass().getAnnotationsByType(Entity.class);
		if (entityAnnotations.length < 1) {
			throw new IllegalArgumentException("No Entity Annotation is present, aborting generation.");
		}

		insertStatement.append(entityAnnotations[0].table());

		insertStatement.append(this.visitFields(user.getClass().getDeclaredFields(), user));

		insertStatement.append("; ");

		if (entityAnnotations[0].autoCommit()) {
			insertStatement.append("commit;");
		}
		
		return insertStatement.toString();
	}

	@Override
	public String visitFields(Field[] fields, User user) throws Exception {

		StringBuffer fieldInsert = new StringBuffer(" (");

		for (Field f : fields) {
			if (f.getAnnotation(Column.class) == null) {
				fieldInsert.append(f.getName().toUpperCase());
			} else {
				fieldInsert.append(f.getAnnotation(Column.class).column().toUpperCase());
			}
			fieldInsert.append(",");
		}

		fieldInsert.deleteCharAt(fieldInsert.length() - 1);
		fieldInsert.append(") VALUES (");

		for (Field f : fields) {
			if (f.getType().isAssignableFrom(String.class)) {
				fieldInsert.append("'");
			}

			fieldInsert.append(f.get(user));

			if (f.getType().isAssignableFrom(String.class)) {
				fieldInsert.append("'");
			}

			fieldInsert.append(",");
		}

		fieldInsert.deleteCharAt(fieldInsert.length() - 1);

		fieldInsert.append(")");

		return fieldInsert.toString();
	}
	
}
