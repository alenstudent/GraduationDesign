package com.aaron.framework.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.MidiDevice.Info;

import org.apache.ibatis.session.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.exception.DBException;
import com.aaron.framework.model.BaseModel;
import com.aaron.framework.model.Page;
import com.aaron.framework.utils.NamespaceUtil;

/**
 * <p>Title: AbstractService</p>
 * <p>Description:</p>
 * @author aaron
 * @date 2016年3月3日 下午9:59:17
 */
public abstract class AbstractService implements BaseService {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	public abstract BaseDao getDao();
	
	@Override
	public int insertBySqlId(String sqlId) throws DBException {
		return this.getDao().insertBySqlId(sqlId);
	}
	@Override
	public int insertBySqlIdAndParam(String sqlId, Object param) throws DBException {
		return this.getDao().insertBySqlIdAndParam(sqlId, param);
	}
	@Override
	public int updateBySqlId(String sqlId) throws DBException {
		return this.getDao().updateBySqlId(sqlId);
	}
	@Override
	public int updateBySqlIdAndParam(String sqlId, Object param) throws DBException {
		return this.getDao().updateBySqlIdAndParam(sqlId, param);
	}
	@Override
	public int deleteBySqlId(String sqlId) throws DBException {
		return this.getDao().deleteBySqlId(sqlId);
	}
	@Override
	public int deleteBySqlIdAndParam(String sqlId, Object param) throws DBException {
		return this.getDao().deleteBySqlIdAndParam(sqlId, param);
	}
	@Override
	public <T> void handlerBySqlId(String sqlId, ResultHandler<T> handler) throws DBException {
		this.getDao().handlerBySqlId(sqlId, handler);
	}
	@Override
	public <T> void handlerBySqlIdAndParam(String sqlId, Object param, ResultHandler<T> handler) throws DBException {
		this.getDao().handlerBySqlIdAndParam(sqlId, param, handler);
	}
	@Override
	public <T> void handlerBySqlIdAndParamWithPage(String sqlId, Object param, Page page, ResultHandler<T> handler)
			throws DBException {
		this.getDao().handlerBySqlIdAndParamWithPage(sqlId, param, page, handler);
	}
	@Override
	public <T> List<T> selectListBySqlId(String sqlId) throws DBException {
		return this.getDao().selectListBySqlId(sqlId);
	}
	@Override
	public <T> List<T> selectListBySqlIdAndParam(String sqlId, Object param) throws DBException {
		return this.getDao().selectListBySqlIdAndParam(sqlId, param);
	}
	@Override
	public <T> List<T> selectListBySqlIdAndParamWithPage(String sqlId, Object param, Page page)
			throws DBException {
		return this.getDao().selectListBySqlIdAndParamWithPage(sqlId, param, page);
	}
	@Override
	public <T> Map<String, T> selectMapBySqlId(String sqlId, String key) throws DBException {
		return this.getDao().selectMapBySqlId(sqlId, key);
	}
	@Override
	public <T> Map<String, T> selectMapBySqlIdAndParam(String sqlId, Object param, String key) throws DBException {
		return this.getDao().selectMapBySqlIdAndParam(sqlId, param, key);
	}
	@Override
	public <T> Map<String, T> selectMapBySqlIdAndParamWithPage(String sqlId, Object param, String key, Page page)
			throws DBException {
		return this.getDao().selectMapBySqlIdAndParamWithPage(sqlId, param, key, page);
	}
	@Override
	public <T> T selectUniqueOneBySqlId(String sqlId) throws DBException {
		return this.getDao().selectUniqueOneBySqlId(sqlId);
	}
	@Override
	public <T> T selectUniqueOneBySqlIdAndParam(String sqlId, Object param) throws DBException {
		return this.getDao().selectUniqueOneBySqlIdAndParam(sqlId, param);
	}
	
	public <T> List<T> list(Page<T> page, Class<? extends BaseModel> clazz) {
		return this.list(page, new Object(), clazz);
	}
	public <T> List<T> list(Page<T> page, Object param, Class<? extends BaseModel> clazz) {
		return this.getDao().selectListBySqlIdAndParamWithPage(NamespaceUtil.getNamespace(clazz, "list"), param, page);
	}
	public int delete(List<String> ids, Class<? extends BaseModel> clazz) {
		return this.getDao().deleteBySqlIdAndParam(NamespaceUtil.getNamespace(clazz, "del"), ids);
	}
	public int update(BaseModel baseModel) {
		return this.getDao().updateBySqlIdAndParam(NamespaceUtil.getNamespace(baseModel.getClass(), "update"), baseModel);
	}
	public int insert(BaseModel baseModel) {
		return this.getDao().insertBySqlIdAndParam(NamespaceUtil.getNamespace(baseModel.getClass(), "insert"), baseModel);
	}
	public <T extends BaseModel> T Info(String id, Class<? extends BaseModel> clazz) {
		return this.getDao().selectUniqueOneBySqlIdAndParam(NamespaceUtil.getNamespace(clazz, "info"), id);
	}
}

