package com.aaron.graduationdesign.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.model.Page;
import com.aaron.framework.service.AbstractService;
import com.aaron.framework.utils.NamespaceUtil;
import com.aaron.graduationdesign.daos.CustomerDao;
import com.aaron.graduationdesign.models.Customer;

/**
 *<pre>
 * 对象功能:客户信息表 Service类
 * 开发人员:aaron
 * 创建时间:2016-04-27 00:02:52
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
	
	
	public List<Customer> getCustomersBySaleId(String saleId, Page<Customer> page) {
		return this.customerDao.selectListBySqlIdAndParamWithPage(NamespaceUtil.getNamespace(Customer.class, "getAllCustomersBySalseId"), saleId, page);
	}


	public void addCustomer(Customer customer) {
		
		this.customerDao.insertBySqlIdAndParam(NamespaceUtil.getNamespace(Customer.class, "addCustomer"), customer);
		
	}
	
}
