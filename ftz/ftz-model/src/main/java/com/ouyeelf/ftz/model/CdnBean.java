package com.ouyeelf.ftz.model;

public class CdnBean extends BaseEntity{
	public CdnBean(){		
	}
	public CdnBean(String url){
		this.url=url;
	}
	
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	

}
