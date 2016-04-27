package com.aaron.framework.utils;

import com.aaron.framework.model.BaseModel;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年3月18日 下午11:16:53
* 类说明：TODO
*/
public class NamespaceUtil {

	public static String getNamespace(Class<? extends BaseModel> clazz, String sqlId) {
		return new StringBuilder().append(clazz.getName()).append(".").append(sqlId).toString();
	}
	public static String getNamespace(String namespaceId) {
		return namespaceId;
	}
}
