package com.aaron.graduationdesign.services;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.aaron.graduationdesign.daos.MyDemoDao;
import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.service.AbstractService;

/**
 *<pre>
 * 对象功能:my_demo Service类
 * 开发人员:aaron
 * 创建时间:2016-04-28 17:07:55
 *</pre>
 */
@Service("myDemoService")
public class MyDemoService extends AbstractService {
	@Resource(name="myDemoDao")
	private MyDemoDao myDemoDao;
	
	@Override
	public BaseDao getDao() {
		return this.myDemoDao;
	}
}
