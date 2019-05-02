package com.cg.myproject.service;
import java.util.List;
import com.cg.myproject.dao.MenuRepository;
import com.cg.myproject.dao.MenuRepositoryImpl;
import com.cg.myproject.dto.Item;
import com.cg.myproject.dto.Menu;
import com.cg.myproject.dto.Restaurant;
import com.cg.myproject.exception.RestaurantNotFoundException;

public class MenuServiceImpl implements MenuService{
	MenuRepositoryImpl repo= new MenuRepositoryImpl() ;

	@Override
	public Restaurant add(Restaurant restaurant) {
		
		return repo.save(restaurant);
	}

	@Override
	public Restaurant searchByNameR(String restaurantName) throws RestaurantNotFoundException{
		
		Restaurant rest = repo.findByName(restaurantName);
		if(rest!=null)
		{
		
			return rest;
		}
		else
		{
		throw new RestaurantNotFoundException("Restaurant not found");
		}
	
		
		
	}
/*
//	@Override
//	public Menu add(Menu menu) {
//		// TODO Auto-generated method stub
//		return null;
//	}
*/

	@Override
	public List<Restaurant> showRestaurant() {
		return repo.getRestaurant();
	}

	
	
	
	
	
	
}
