package com.test.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ParentalLevelEnum {
	
	U("U",0),
	PG("PG",1),
	TWELVE("TWELVE",12),
	FIFTEEN("FIFTEEN",15),
	EIGHTEEN("EIGHTEEN",18); 
	
	String value;
	Integer ageRestrictionLevel;
	
	public Integer getAgeRestrictionLevel() {
		return ageRestrictionLevel;
	}

	public void setAgeRestrictionLevel(Integer ageRestrictionLevel) {
		this.ageRestrictionLevel = ageRestrictionLevel;
	}

	protected static Map<ParentalLevelEnum, Integer> parentLevelMap = new HashMap<ParentalLevelEnum, Integer>();
	
	
	protected static Map<ParentalLevelEnum, Integer> parentLevelMappings() {
		
	
		return parentLevelMap;
		
	}
	
	ParentalLevelEnum(String value, Integer ageRestrictionLevel) {
				
		this.ageRestrictionLevel = ageRestrictionLevel;
		
	}

	public static boolean isInputRatingGreaterThanRequiredRating(ParentalLevelEnum inputParentalControl,
			ParentalLevelEnum requiredParentalLevel) throws IllegalArgumentException {
		
		
		if(!isValidParentLevel(inputParentalControl))
			throw new IllegalArgumentException("InValid Parental Rating Input");
		
		if(inputParentalControl.getAgeRestrictionLevel() >= requiredParentalLevel.getAgeRestrictionLevel()) 
			return true;
		
		
		return false;
		
	}
	
	
	
	public static boolean isValidParentLevel(ParentalLevelEnum parentLevel) {
		
		EnumSet<ParentalLevelEnum> allOf = EnumSet.allOf(ParentalLevelEnum.class);
		
		return EnumSet.allOf(ParentalLevelEnum.class).contains(parentLevel);
			
			
		
	}

}
