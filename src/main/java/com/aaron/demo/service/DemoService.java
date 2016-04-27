package com.aaron.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaron.demo.dao.DemoDao;
import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.service.AbstractService;

/**
 * <p>Title: DemoService</p>
 * <p>Description:</p>
 * @author aaron
 * @date 2016年3月3日 下午10:59:14
 */
@Service("demoService")
public class DemoService extends AbstractService {

	@Resource(name = "demoDao")
	private DemoDao demoDao;

	@Override
	public BaseDao getDao() {
		return this.demoDao;
	}

//	/**
//	 * 添加100个测试用例
//	 */
//	public void insert100Demo() {
//		List<Demo> demos = new ArrayList<Demo>();
//		for (int i = 0 ; i < 100; i++) {
//			Demo demo = new Demo();
//			demo.setName(i + "");
//			demo.setUniqueId(IDUtil.generateUUID().toString());
//			demo.setAge(i);
//			demos.add(demo);
//		}
//		this.insertBySqlIdAndParam("insertDemo", demos);
//		throw new DBException("test");
//	}
}

