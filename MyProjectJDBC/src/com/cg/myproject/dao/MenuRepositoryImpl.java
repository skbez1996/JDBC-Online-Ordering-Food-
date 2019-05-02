package com.cg.myproject.dao;

import static org.mockito.Mockito.stubVoid;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cg.myproject.DBUtil.DBUtil;
import com.cg.myproject.dto.Item;
import com.cg.myproject.dto.Menu;
import com.cg.myproject.dto.Restaurant;
import com.cg.myproject.exception.RestaurantNotFoundException;

public class MenuRepositoryImpl implements MenuRepository {
	PreparedStatement pstm;


	public MenuRepositoryImpl() {

	}


	@Override
	public Restaurant save(Restaurant restaurant) throws RestaurantNotFoundException {
		Connection conn = DBUtil.getConnection();
		try {
			int item_id=0;
			pstm = conn.prepareStatement("select max(item_id) from items");
			ResultSet result1 = pstm.executeQuery();
			if(result1.next())
			{
				item_id=result1.getInt(1);
			}
			int menuId=0;
			
			pstm = conn.prepareStatement(MenuRepository.queryInsertMenu);
			pstm.setString(1,restaurant.getMenu().getMenuName());
			pstm.executeUpdate();

			pstm = conn.prepareStatement("select max(menu_id) from menu");
			ResultSet result = pstm.executeQuery();
			if(result.next()) {
				menuId = result.getInt(1); 

			}

			pstm = conn.prepareStatement(MenuRepository.queryInsertItem);

			for (Item item : restaurant.getMenu().getItemName()) {
				pstm.setString(1,item.getName());
				pstm.setDouble(2,item.getPrice());
				pstm.setString(3,item.getDescription());
				pstm.setInt(4, menuId);
				pstm.executeUpdate();
			}
				pstm = conn.prepareStatement(MenuRepository.queryInsertRestaurant);
				pstm.setString(1, restaurant.getName());

				pstm.setString(2, restaurant.getPhone().toString());
				pstm.setString(3, restaurant.getAddress());
				pstm.setInt(4, menuId);
				pstm.executeUpdate();

			


			return restaurant;


		}catch(SQLException e) {
			e.printStackTrace();


		}finally {
			try {


				pstm.close();
				conn.close();

			}catch (SQLException e)
			{
				throw new RestaurantNotFoundException("Connection not able to close");
			}
		}
		return null;
	}

	@Override
	public Restaurant findByName(String name) {

		Connection conn = DBUtil.getConnection();
		List<Item> items = new ArrayList<>();
		Restaurant rest = new Restaurant();
		try {
			String querySelectRestaurantByName = "select * from restaurants where name =?"; 
			pstm = conn.prepareStatement(querySelectRestaurantByName);
			pstm.setString(1,name);
			ResultSet result = pstm.executeQuery();
			Restaurant res=new Restaurant();
			if(result.next()) {	
	
				res.setName(result.getString(1));
				res.setPhone(new BigInteger(result.getString(2)));
				res.setAddress(result.getString(3));
		//String querySelectMenu = "select name,price,description from menu inner join items on menu.menu_id=items.menu_id where menu.menu_id =?"; 
	//			String querySelectMenu = "select *  from restraunts inner join items on restraunts.menu_id=items.menu_id where restraunt.name=?"; 
				
				/*pstm = conn.prepareStatement(querySelectMenu);
				pstm.setInt(1,result.getInt(4));
				ResultSet rs= pstm.executeQuery();
				rs.next();
//				System.out.println("drt"+rs.getString(2));
				String menuName=null;
				while(rs.next()) {
					menuName=	result.getString(1);
					Item item=new Item(rs.getString(1),rs.getDouble(2),rs.getString(3));
					Menu menu=new Menu(menuName,items);
					  res.setMenu(menu);
				}*/
				
				/*Menu menu=new Menu(menuName,items);
				  res.setMenu(menu)*/;
				 
				return res;
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	
		return rest;
	}


	@Override
	public List<Restaurant> getRestaurant() {
		Connection conn = DBUtil.getConnection();
		List<Restaurant> myList = new ArrayList<>();
	
		try {
			String querySelectRestaurant = "select * from restaurants"; 
			pstm = conn.prepareStatement(querySelectRestaurant);
			ResultSet result = pstm.executeQuery();
	
			while(result.next()) {	
					
				 	Restaurant res=new Restaurant();
					String str1=result.getString(1);
					Long str2=result.getLong(2);
					BigInteger phn=BigInteger.valueOf(str2);
					String str3=result.getString(3);
					res.setName(str1);
					res.setPhone(phn);
					res.setAddress(str3);
					
					myList.add(res);
					
			}
	

		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		return myList;

	}




}
