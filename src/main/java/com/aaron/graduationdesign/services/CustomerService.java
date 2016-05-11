package com.aaron.graduationdesign.services;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.aaron.graduationdesign.daos.CustomerDao;
import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.service.AbstractService;

/**
 *<pre>
 * 对象功能:客户信息表 Service类
 * 开发人员:aaron
 * 创建时间:2016-04-28 17:17:40
 *</pre>
 */
@Service("customerService")
public class CustomerService extends AbstractService {
	@Resource(name="customerDao")
	private CustomerDao customerDao;
	
	@Override
	public BaseDao getDao() {
		return this.customerDao;
	}
}
