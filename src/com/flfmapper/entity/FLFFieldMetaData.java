package com.flfmapper.entity;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Objects;

public class FLFFieldMetaData<T> {
	private T parentObject;
	private String flfFieldText;
	private PropertyDescriptor propertyDescriptor;
	private Field field;
	
	public T getParentObject() {
		return parentObject;
	}
	public void setParentObject(T parentObject) {
		this.parentObject = parentObject;
	}
	public String getFlfFieldText() {
		return flfFieldText;
	}
	public void setFlfFieldText(String flfFieldText) {
		this.flfFieldText = flfFieldText;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public PropertyDescriptor getPropertyDescriptor() {
		return propertyDescriptor;
	}
	public void setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
		this.propertyDescriptor = propertyDescriptor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(field, flfFieldText, parentObject, propertyDescriptor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FLFFieldMetaData<?> other = (FLFFieldMetaData<?>) obj;
		return Objects.equals(field, other.field) && Objects.equals(flfFieldText, other.flfFieldText)
				&& Objects.equals(parentObject, other.parentObject)
				&& Objects.equals(propertyDescriptor, other.propertyDescriptor);
	}
	
	@Override
	public String toString() {
		return "FLFFieldMetaData [parentObject=" + parentObject + ", flfFieldText=" + flfFieldText
				+ ", propertyDescriptor=" + propertyDescriptor + ", field=" + field + "]";
	}
}