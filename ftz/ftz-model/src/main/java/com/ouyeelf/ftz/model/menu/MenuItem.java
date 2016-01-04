package com.ouyeelf.ftz.model.menu;

public class MenuItem {
	private String id;
	private String label;
	private String uri;
	
	public MenuItem(String id,String label){
		setId(id);
		setLabel(label);
	}
	public MenuItem(String id,String label,String uri){
		setId(id);
		setLabel(label);
		setUri( uri);
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
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
}
