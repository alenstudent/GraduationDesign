package com.aaron.framework.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aaron.framework.exception.DBException;
import com.aaron.framework.model.Page;
import com.aaron.framework.mybatisinterceptor.PageInterceptor;

/**
 * <p>Title: AbstractDao</p>
 * <p>Description:</p>
 * @author aaron
 * @date 2016年3月3日 下午9:25:40
 */
public abstract class AbstractDao extends SqlSessionDaoSupport implements BaseDao {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource(name = "sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 添加操作（根据mapper文件的sqlId进行insert操作）
	 * @param sqlId mapper文件的sqlId
	 */
	@Override
	public int insertBySqlId(String sqlId) throws DBException {
		try {
			return this.getSqlSession().insert(sqlId);	
		} catch (RuntimeException e) {
			log.error("insertBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
		
	}

	/**
	 * 添加操作（根据mapper文件的sqlId进行insert操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	@Override
	public int insertBySqlIdAndParam(String sqlId, Object param) throws DBException {
		try {
			return this.getSqlSession().insert(sqlId, param);
		} catch (RuntimeException e) {
			log.error("insertBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * 更新操作（根据mapper文件的sqlId进行update操作）
	 */
	@Override
	public int updateBySqlId(String sqlId) throws DBException {
		try {
			return this.getSqlSession().update(sqlId);
		} catch (RuntimeException e) {
			log.error("updateBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 更新操作（根据mapper文件的sqlId进行update操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	@Override
	public int updateBySqlIdAndParam(String sqlId, Object param) throws DBException {
		try {
			return this.getSqlSession().update(sqlId, param);
		} catch (RuntimeException e) {
			log.error("updateBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 删除操作（根据mapper文件的sqlId进行delete操作）
	 */
	@Override
	public int deleteBySqlId(String sqlId) throws DBException {
		try {
			return this.getSqlSession().delete(sqlId);
		} catch (RuntimeException e) {
			log.error("deleteBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 删除操作（根据mapper文件的sqlId进行delete操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 */
	@Override
	public int deleteBySqlIdAndParam(String sqlId, Object param) throws DBException {
		try {
			return this.getSqlSession().delete(sqlId, param);
		} catch (RuntimeException e) {
			log.error("deleteBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理）
	 * @param sqlId mapper文件的sqlId
	 * @param handler 结果集处理类
	 */
	@Override
	public <T> void handlerBySqlId(String sqlId, ResultHandler<T> handler) throws DBException {
		try {
			this.getSqlSession().select(sqlId, handler);;
		} catch (RuntimeException e) {
			log.error("handlerBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
		
	}

	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param handler 结果集处理类
	 */
	@Override
	public <T> void handlerBySqlIdAndParam(String sqlId, Object param, ResultHandler<T> handler) throws DBException {
		try {
			this.getSqlSession().select(sqlId, param, handler);;
		} catch (RuntimeException e) {
			log.error("handlerBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 对结果集进行处理（根据mapper文件的sqlId进行进行的select操作后得到的结果集进行回调处理, 带分页）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param page 分页实体对象
	 * @param handler 结果集处理类
	 */
	@Override
	public <T> void handlerBySqlIdAndParamWithPage(String sqlId, Object param, Page page,
			ResultHandler<T> handler) throws DBException {
		try {
			PageInterceptor.startPage(page.getCurrentPage(), page.getPageSize());
			this.getSqlSession().select(sqlId, param, handler);;
			PageInterceptor.endPage();
		} catch (RuntimeException e) {
			log.error("handlerBySqlIdAndParamWithPage 发生异常 >>>> sqlId: " + sqlId + ", param: " + param + ", page: " + page, e);
			throw new DBException(e.getMessage());
		}

		
	}

	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @return 结果集
	 */
	@Override
	public <T> List<T> selectListBySqlId(String sqlId) throws DBException {
		try {
			return this.getSqlSession().selectList(sqlId);
		} catch (RuntimeException e) {
			log.error("selectListBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @return 结果集
	 */
	@Override
	public <T> List<T> selectListBySqlIdAndParam(String sqlId, Object param) throws DBException {
		try {
			return this.getSqlSession().selectList(sqlId, param);
		} catch (RuntimeException e) {
			log.error("selectListBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 带分页的查询操作（根据mapper文件的sqlId进行进行的selectList操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param page 分页实体对象
	 * @return 结果集
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> List<T> selectListBySqlIdAndParamWithPage(String sqlId, Object param, Page page) throws DBException {
		try {
			PageInterceptor.startPage(page);
			this.getSqlSession().selectList(sqlId, param);
			
			return PageInterceptor.endPage().getResult();
		} catch (RuntimeException e) {
			log.error("selectListBySqlIdAndParamWithPage 发生异常 >>>> sqlId: " + sqlId + ", param: " + param + ", page: " + page, e);
			throw new DBException(e.getMessage());
		}
	}

	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param key 健值
	 * @return 结果集
	 */
	@Override
	public <T> Map<String, T> selectMapBySqlId(String sqlId, String key) throws DBException {
		try {
			return this.getSqlSession().selectMap(sqlId, key);
		} catch (RuntimeException e) {
			log.error("selectMapBySqlId 发生异常 >>>> sqlId: " + sqlId + ", key: " + key, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param key 健值
	 * @return 结果集
	 */
	@Override
	public <T> Map<String, T> selectMapBySqlIdAndParam(String sqlId, Object param, String key) throws DBException {
		try {
			return this.getSqlSession().selectMap(sqlId, param, key);
		} catch (RuntimeException e) {
			log.error("selectMapBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", key: " + key + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * #### 还未实现 ####
	 * 带分页的查询操作（根据mapper文件的sqlId进行进行的selectMap操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @param key 健值
	 * @param page 分页实体对象
	 * @return 结果集
	 */
	@Override
	public <T> Map<String, T> selectMapBySqlIdAndParamWithPage(String sqlId, Object param, String key, Page page) throws DBException {
		return null;
	}

	/**
	 * 唯一查询操作（根据mapper文件的sqlId进行进行的selectOne操作）
	 * @param sqlId mapper文件的sqlId
	 * @return 唯一结果集实体对象
	 */
	@Override
	public <T> T selectUniqueOneBySqlId(String sqlId) throws DBException {
		try {
			return this.getSqlSession().selectOne(sqlId);
		} catch (RuntimeException e) {
			log.error("selectUniqueOneBySqlId 发生异常 >>>> sqlId: " + sqlId, e);
			throw new DBException(e.getMessage());
		}
	}
	/**
	 * 唯一查询操作（根据mapper文件的sqlId进行进行的selectOne操作）
	 * @param sqlId mapper文件的sqlId
	 * @param param 参数(可以是实体，也可以是map健值对)
	 * @return 唯一结果集实体对象
	 */
	@Override
	public <T> T selectUniqueOneBySqlIdAndParam(String sqlId, Object param) throws DBException {
		try {
			return this.getSqlSession().selectOne(sqlId, param);
		} catch (RuntimeException e) {
			log.error("selectUniqueOneBySqlIdAndParam 发生异常 >>>> sqlId: " + sqlId + ", param: " + param, e);
			throw new DBException(e.getMessage());
		}
	}


	
}

