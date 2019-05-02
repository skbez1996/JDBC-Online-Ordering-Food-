package com.cg.myproject.dao;

import java.util.List;

import com.cg.myproject.dto.Item;
import com.cg.myproject.dto.Restaurant;

public interface MenuRepository {
	
	public static final String queryInsertRestaurant= "INSERT INTO restaurants(name,phone,address,menu_id) values(?,?,?,?) ";

	public static final String queryInsertMenu= "INSERT INTO menu(menu_name) values(?) ";
	
	public static final String queryInsertItem= "INSERT INTO items(name,price,description,menu_id) values(?,?,?,?) ";
	
	
	public Restaurant save(Restaurant restaurant);
	public Restaurant findByName(String name);
	public List<Restaurant> getRestaurant();
	

}