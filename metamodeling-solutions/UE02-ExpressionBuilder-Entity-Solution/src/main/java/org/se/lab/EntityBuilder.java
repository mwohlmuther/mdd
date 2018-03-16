package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public class EntityBuilder
{
	private String name;
	private List<PropertyBuilder> properties = new ArrayList<PropertyBuilder>();
	
	/**
	 * Akzeptiert den Namen als Parameter und liefert wieder das modifizierte Builder-Objekt zurück.
	 * 
	 * @param name
	 * @return this
	 */
	public EntityBuilder name(String name)
	{
		this.name = name;
		return this;
	}
		
	/**
	 * Erstellt das Entity Objekt erst beim Aufruf von toEntity.
	 * @return
	 */
	public MEntity toEntity()
	{
		MEntity entity = new MEntity(name);
		for(PropertyBuilder b : properties)
		{
			entity.getProperties().add(b.toProperty());
		}
		return entity;
	}

	
	/*
	 * Fluent interface methods
	 */
	
	public PropertyBuilder property(String name)
	{
		PropertyBuilder child = new PropertyBuilder(name);
		properties.add(child);		
		return child;
	}

	
	/*
	 * Nested property builder
	 */
	public class PropertyBuilder
	{
		private String name;
		private MType type;
		private boolean id;
		
		private PropertyBuilder(String name)
		{
			this.name = name;	
		}
				
		/**
		 * Das MProperty Objekt wird auch erst erstellt wenn die Entity erstellt wird,
		 * zuvor wird lediglich eine Liste von PropertyBuildern vorgehalten.
		 * @return
		 */
		private MProperty toProperty()
		{
			MProperty property = new MProperty(name, type);
			property.setId(id);
			return property;
		}

		
		/*
		 * Fluent interface methods
		 */
		
		public PropertyBuilder isId()
		{
			id = true;
			return this;
		}
		
		public PropertyBuilder asInt()
		{
			type = new MInteger();
			return this;
		}
		
		public PropertyBuilder asString()
		{
			type = new MString();
			return this;
		}
		
		public PropertyBuilder property(String name)
		{
			return EntityBuilder.this.property(name);
		}
		
		public MEntity toEntity()
		{
			return EntityBuilder.this.toEntity();
		}
	}
}
