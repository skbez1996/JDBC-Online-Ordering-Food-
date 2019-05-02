package com.cg.myproject.dto;

import java.util.List;

public class Menu {
	private String menuName;
	private int menuId;
	private List <Item> itemName  ;
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Menu(String menuName, List<Item> itemName) {
		super();
		this.menuName = menuName;
	
		this.itemName = itemName;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public List<Item> getItemName() {
		return itemName;
	}
	public void setItemName(List<Item> itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", menuId=" + menuId + ", itemName=" + itemName + "]";
	}
	
	

	
	
	
	

}
