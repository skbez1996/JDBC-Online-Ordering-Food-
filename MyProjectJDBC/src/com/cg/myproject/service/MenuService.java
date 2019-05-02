package com.cg.myproject.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.myproject.dto.Item;
import com.cg.myproject.dto.Menu;
import com.cg.myproject.dto.Restaurant;
import com.cg.myproject.exception.RestaurantNotFoundException;

public interface MenuService {
	public Restaurant add(Restaurant restaurant);
	public Restaurant searchByNameR(String restaurantName) throws RestaurantNotFoundException;
	//public Menu add(Menu menu);
	public List<Restaurant> showRestaurant();

	
	
	
}
