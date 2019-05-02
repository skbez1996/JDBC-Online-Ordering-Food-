package com.cg.myproject.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.ws.Service;

import com.cg.myproject.DBUtil.DBUtil;
import com.cg.myproject.dto.Item;
import com.cg.myproject.dto.Menu;
import com.cg.myproject.dto.Restaurant;
import com.cg.myproject.exception.RestaurantNotFoundException;
import com.cg.myproject.service.MenuService;
import com.cg.myproject.service.MenuServiceImpl;

public class MyApplication {
	
public static void main(String args[]) {
	Scanner sc= new Scanner (System.in);
	
	
	MenuServiceImpl service = new MenuServiceImpl();
		int choice;
	do {
		System.out.println(" 1.Add Restaurants \n 2.Show Restaurants \n 3.Search Restaurant by name \n 4 .Exit");
    choice= sc.nextInt();
	switch (choice) {
	case 1: 
		
		List <Item> itemList = new ArrayList<>();
		
		
		System.out.println("enter restaurant name");
		String rname = sc.next();
		System.out.println("enter restaurant phone number");
		BigInteger rmobile = sc.nextBigInteger();
		System.out.println("enter restaurant city");
		String rcity = sc.next();
		
		
		
		System.out.println("enter menu name");
		String menuName = sc.next();
		
		String ch ;
		
		do {
		System.out.println("enter item name");
		String itemName= sc.next();
		
		System.out.println("enter item price");
		double itemPrice = sc.nextDouble();
		
		System.out.println("enter item description");
		String description = sc.next();
		
		Item item = new Item(itemName, itemPrice, description);
		itemList.add(item);
		
		System.out.println("do you want add more items(yes/no)");
		 ch = sc.next();
		
		}while(ch.equals("yes"));
		
		Menu menu = new Menu(menuName,itemList);
		
		Restaurant  restaurant = new Restaurant(rname, rmobile, rcity,menu);
		
	
		service.add(restaurant);

		System.out.println("Restaurants added Successfully");
		break;

	case 2:List<Restaurant> restur= service.showRestaurant();
	  
	for (Restaurant rest : restur) {
		  System.out.println("rest name: "+rest.getName());
		  System.out.println("rest phone: "+rest.getPhone());
		  System.out.println("rest addr: "+rest.getAddress());
	}
	
		break;
	
	case 3 :
		List<Restaurant> restaurants = new ArrayList<Restaurant>() ;
		

		System.out.println("Enter the name of the restaurant to search");
		String Rname =sc.next();
	
		try {
			System.out.println(service.searchByNameR(Rname));
			
		} catch (RestaurantNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		break;
	case 4: break;
	
		
	}
	}
	while(choice != 4) ;
}

}




























//Item itemThree = new Item("item3", 150.0, "The  3rd item");
//Item itemFour  = new Item("item4", 150.0, "The  4th item");
//Item itemFive  = new Item("item5", 130.0, "The  5th item");
//Item itemSix   = new Item("item6", 150.30, "The 6th item");
//Item itemSeven = new Item("item7", 150.20, "The 7th item");
//Item itemEight = new Item("item8", 1504.0, "The 8th item");
//Item itemNine  = new Item("item9", 1509.0, "The 9th item");
//Item itemTen   = new Item("item10", 150.0, "The 10th item");
//
//
//
//itemList.add(item)     ;
//itemList.add(itemOne)  ;
//itemList.add(itemThree);
//itemList.add(itemFour) ;
//itemList.add(itemFive) ;
//itemList.add(itemSix)  ;
//itemList.add(itemSeven);
//itemList.add(itemEight);
//itemList.add(itemNine) ;
//itemList.add(itemTen) ;




//System.out.println("Enter the Restraurant Name : ");
//					String name  = sc.next();
//					System.out.println("Enter the phone number : ");
//					String phone = sc.next();
//					System.out.println("Enter the address : ");
//					String address = sc.next();
//					
//					
//		List<Item> items = new ArrayList<>();
//	String ch= "Y";
//	do {
//					System.out.println("Enter the Item Name : ");
//					String item_name = sc.next();
//					System.out.println("Enter the Item item Price : ");
//					double item_price = sc.nextDouble();
//					System.out.println("Enter the Item description");
//					String item_desc =sc.next();
//					
//					items.add(new Item(item_name,item_price,item_desc));
//					System.out.println("Enter more item ? (Y or N): ");
//					
//					ch=sc.next();
//					}while(ch.equals("Y") || ch.equals("y"));
//					
//					Restaurant restaurant =new Restaurant(name,new BigInteger(phone),address,Menu);
//					service.add(restaurant); 
//		 

