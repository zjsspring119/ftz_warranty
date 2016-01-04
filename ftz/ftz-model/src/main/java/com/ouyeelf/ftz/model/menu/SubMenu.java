package com.ouyeelf.ftz.model.menu;

import java.util.List;

public class SubMenu {
	private String id;
	private String  label;
	private String  uri;
	private List<MenuItem> menuItems;
	
	public SubMenu(String id,String  label){
		setId(id);
		setLabel(label);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	
	
}
