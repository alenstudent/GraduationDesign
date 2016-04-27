package com.aaron.graduationdesign.services;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.aaron.graduationdesign.daos.ProductDao;
import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.service.AbstractService;

/**
 *<pre>
 * 对象功能:产品信息表 Service类
 * 开发人员:aaron
 * 创建时间:2016-04-27 00:04:20
 *</pre>
 */
@Service("productService")
public class ProductService extends AbstractService {
	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Override
	public BaseDao getDao() {
		return this.productDao;
	}
}
