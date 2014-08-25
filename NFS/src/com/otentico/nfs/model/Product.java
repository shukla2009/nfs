package com.otentico.nfs.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String id;
	private String name;
	private String logo;
	private List<Property> properties;

	public Product(String id) {
		this.id = id;
		properties = new ArrayList<Property>();
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void addProperties(Property property) {
		properties.add(property);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id : ");
		sb.append(getId());
		sb.append("\n");
		sb.append("name : ");
		sb.append(getName());
		sb.append("\n");

		for (Property p : getProperties()) {
			sb.append(p.getKey() + " : ");
			sb.append(p.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}

}
