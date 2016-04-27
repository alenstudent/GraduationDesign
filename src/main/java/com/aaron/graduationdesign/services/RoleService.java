package com.aaron.graduationdesign.services;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.service.AbstractService;
import com.aaron.framework.utils.NamespaceUtil;
import com.aaron.graduationdesign.daos.RoleDao;
import com.aaron.graduationdesign.models.Role;

/**
 *<pre>
 * 对象功能:角色表 Service类
 * 开发人员:aaron
 * 创建时间:2016-04-26 00:24:02
 *</pre>
 */
@Service("roleService")
public class RoleService extends AbstractService {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao getDao() {
		return this.roleDao;
	}
	
	public List<Role> getRoles() {
		return this.roleDao.selectListBySqlId(NamespaceUtil.getNamespace(Role.class, "getAllRoles"));
	}
	
}
