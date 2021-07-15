package com.flfmapper.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.flfmapper.entity.FLFFieldMetaData;

public class FLFBooleanMapper implements FLFFieldMapper {
	private static final Set<String> BOOLEAN_TRUE_STRINGS;
	private static final Set<String> BOOLEAN_FALSE_STRINGS;
	static {
		Set<String> booleanTrueStringTypes = new HashSet<>();
		booleanTrueStringTypes.add("Y");
		booleanTrueStringTypes.add("y");
		booleanTrueStringTypes.add("True");
		booleanTrueStringTypes.add("true");
		booleanTrueStringTypes.add("1");
		BOOLEAN_TRUE_STRINGS = Collections.unmodifiableSet(booleanTrueStringTypes);
		
		Set<String> booleanFalseStringTypes = new HashSet<>();
		booleanTrueStringTypes.add("N");
		booleanTrueStringTypes.add("n");
		booleanTrueStringTypes.add("False");
		booleanTrueStringTypes.add("false");
		booleanTrueStringTypes.add("0");
		BOOLEAN_FALSE_STRINGS = Collections.unmodifiableSet(booleanFalseStringTypes);
	}
	
	@Override
	public boolean isReturnTypeHandled(Class<?> readMethodReturnType) {
		return Boolean.TYPE.equals(readMethodReturnType) || Boolean.class.equals(readMethodReturnType);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T, F> F mapToType(FLFFieldMetaData<T> flfFieldMetaData) {
		if(BOOLEAN_FALSE_STRINGS.contains(flfFieldMetaData.getFlfFieldText())) {
			return (F) Boolean.FALSE;
		} else if(BOOLEAN_TRUE_STRINGS.contains(flfFieldMetaData.getFlfFieldText())) {
			return (F) Boolean.TRUE;
		}
		return (F) Boolean.FALSE;
	}
	
	@Override
	public <T> String maptToString(FLFFieldMetaData<T> flfFieldMetaData) {
		String parsedObjectString;
		
		try {
			parsedObjectString = String.valueOf(flfFieldMetaData.getPropertyDescriptor().getReadMethod().invoke(flfFieldMetaData.getParentObject()));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		return parsedObjectString == null ? "" : parsedObjectString.trim();
	}
}