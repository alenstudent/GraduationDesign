package com.aaron.framework.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultHandler;

import com.aaron.framework.exception.DBException;
import com.aaron.framework.model.Page;

/**
 * 
 * <p>Title: BaseDao</p>
 * <p>Description:增删改查组件通用规范接口</p>
 * @author aaron
 * @date 2016年2月29日 上午11:08:48
 */
public interface BaseDao {
	/**
	 * 添加操作（根据mapper文件的sqlId进行insert操作）
	 * @param sqlId mapper文件的sqlId
	 */
	public int insertBySqlId(String sqlId) throws DBException;
	/**
	 * 添加操作（根据mapper文件的sqlId进行insert操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	public int insertBySqlIdAndParam(String sqlId, Object param) throws DBException;
	/**
	 * 更新操作（根据mapper文件的sqlId进行update操作）
	 */
	public int updateBySqlId(String sqlId) throws DBException;
	/**
	 * 更新操作（根据mapper文件的sqlId进行update操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	public int updateBySqlIdAndParam(String sqlId, Object param) throws DBException;
	/**
	 * 删除操作（根据mapper文件的sqlId进行delete操作）
	 */
	public int deleteBySqlId(String sqlId) throws DBException;
	/**
	 * 删除操作（根据mapper文件的sqlId进行delete操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	public int deleteBySqlIdAndParam(String sqlId, Object param) throws DBException;
	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理）
	 * @param sqlId mapper文件的sqlId
	 * @param handler 结果集处理类
	 */
	public <T> void handlerBySqlId(String sqlId, ResultHandler<T> handler) throws DBException;
	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param handler 结果集处理类
	 */
	public <T> void handlerBySqlIdAndParam(String sqlId, Object param, ResultHandler<T> handler) throws DBException;
	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理, 带分页）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param page 分页实体对象
	 * @param handler 结果集处理类
	 */
	public <T> void handlerBySqlIdAndParamWithPage(String sqlId, Object param, Page page, ResultHandler<T> handler) throws DBException;
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @return 结果集
	 */
	public <T> List<T> selectListBySqlId(String sqlId) throws DBException;
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @return 结果集
	 */
	public <T> List<T> selectListBySqlIdAndParam(String sqlId, Object param) throws DBException;
	/**
	 * 带分页的查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param page 分页实体对象
	 * @return 结果集
	 */
	public <T> List<T> selectListBySqlIdAndParamWithPage(String sqlId, Object param, Page page) throws DBException;
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param key 健值
	 * @return 结果集
	 */
	public <T> Map<String, T> selectMapBySqlId(String sqlId, String key) throws DBException;
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param key 健值
	 * @return 结果集
	 */
	public <T> Map<String, T> selectMapBySqlIdAndParam(String sqlId, Object param, String key) throws DBException;
	/**
	 * 带分页的查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param key 健值
	 * @param page 分页实体对象
	 * @return 结果集
	 */
	public <T> Map<String, T> selectMapBySqlIdAndParamWithPage(String sqlId, Object param, String key, Page page) throws DBException;
	/**
	 * 唯一查询操作（根据mapper文件的sqlId进行进行的selectOne操作）
	 * @param sqlId mapper文件的sqlId
	 * @return 唯一结果集实体对象
	 */
	public <T> T selectUniqueOneBySqlId(String sqlId) throws DBException;
	/**
	 * 唯一查询操作（根据mapper文件的sqlId进行进行的selectOne操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @return 唯一结果集实体对象
	 */
	public <T> T selectUniqueOneBySqlIdAndParam(String sqlId, Object param) throws DBException;
}
