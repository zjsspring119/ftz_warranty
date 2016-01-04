package com.ouyeelf.ftz.service;

import java.util.List;

import com.ouyeelf.ftz.model.CdnBean;

public interface CdnService {
	/**
	 * 获取有效的CDN服务器host and port
	 * @return cdnList
	 */
	public List<CdnBean> getValidCdns();

}
