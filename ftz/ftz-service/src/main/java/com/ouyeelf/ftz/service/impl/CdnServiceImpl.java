package com.ouyeelf.ftz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bsteel.cdn.resolver.CDNServer;
import com.ouyeelf.ftz.model.CdnBean;
import com.ouyeelf.ftz.service.CdnService;

public class CdnServiceImpl implements CdnService {

	public List<CdnBean> getValidCdns() {
		String[] serverNames = CDNServer.getInstance().getServerNames();
		
		List<CdnBean> cdns = new ArrayList<CdnBean>();
		for (String name: serverNames) {
			cdns.add(new CdnBean(name));
		}
		
		return cdns;
		
	}

}
