package com.aaron.framework.dao;

import java.util.UUID;

/**
 * <p>Title: IDUtil</p>
 * <p>Description: ID生成器</p>
 * @author aaron
 * @date 2016年3月3日 下午10:16:29
 */
public class IDUtil {
	/**
	 * 生成UUID
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}

