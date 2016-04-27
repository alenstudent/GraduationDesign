package com.aaron.framework.utils;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheUtil {
	private static final String path = "/ehcache.xml";
	public static String JSESSIONID_CACHE_NAME = "JSESSIONID";

	private URL url;

	private CacheManager manager;

	private static EhCacheUtil ehCache;

	private EhCacheUtil(String path) {
		url = getClass().getResource(path);
		manager = CacheManager.create(url);
	}

	public static EhCacheUtil getInstance() {
		if (ehCache == null) {
			ehCache = new EhCacheUtil(path);
		}
		return ehCache;
	}

	/**
	 * 设置缓存
	 * @param cacheName 缓存名字
	 * @param key 缓存键值
	 * @param value 缓存值
	 */
	public void put(String cacheName, String key, Object value) {
		Cache cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}

	/**
	 * 获取缓存
	 * @param cacheName 缓存名字
	 * @param key 缓存键值
	 * @return
	 */
	public Object get(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}

	/**
	 * 获取缓存
	 * @param cacheName 缓存名字
	 * @return
	 */
	public Cache get(String cacheName) {
		return manager.getCache(cacheName);
	}

	/**
	 * 删除缓存
	 * @param cacheName 缓存名字
	 * @param key 缓存键值
	 */
	public void remove(String cacheName, String key) {
		Cache cache = manager.getCache(cacheName);
		cache.remove(key);
	}
	/**
	 * 更新缓存
	 * @param cacheName 缓存名字
	 * @param key 缓存键值
	 * @param value 缓存值
	 */
	public void update(String cacheName, String key, Object value) {
		Cache cache = manager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}
}
