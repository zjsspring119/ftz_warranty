package com.ouyeelf.ftz.model.menu;

import java.util.List;

public class Menu {
	/*private Integer id;
	private String label;
	private String type;
	private String cssClass;*/

	private List<SubMenu> subMenus;

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

}
