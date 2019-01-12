package com.test.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
	
	Object a ="test";
	
	
	public <T extends Number> List<T> fromArrayToList(T[] a){
		return null;
		
	}
	
	public static void paintAllBuildings(List<? extends Building> buildings) {
		
	}
	
public static void paintAllHouse(List<? super House> houses) {
		
	}
	
	public static void main(String[] args) {
		
		Building b = new House();
		
		((House) b).testHouse();
		
		List<House> houseList = new ArrayList<>();
		
		paintAllBuildings(houseList);
	}

}
