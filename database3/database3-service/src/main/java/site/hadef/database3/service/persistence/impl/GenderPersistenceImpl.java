/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package site.hadef.database3.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import site.hadef.database3.exception.NoSuchGenderException;
import site.hadef.database3.model.Gender;
import site.hadef.database3.model.impl.GenderImpl;
import site.hadef.database3.model.impl.GenderModelImpl;
import site.hadef.database3.service.persistence.GenderPersistence;

/**
 * The persistence implementation for the gender service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GenderPersistenceImpl
	extends BasePersistenceImpl<Gender> implements GenderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GenderUtil</code> to access the gender persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GenderImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GenderPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("genderId", "id");
		dbColumnNames.put("genderName", "name");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(Gender.class);
	}

	/**
	 * Caches the gender in the entity cache if it is enabled.
	 *
	 * @param gender the gender
	 */
	@Override
	public void cacheResult(Gender gender) {
		entityCache.putResult(
			GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
			gender.getPrimaryKey(), gender);

		gender.resetOriginalValues();
	}

	/**
	 * Caches the genders in the entity cache if it is enabled.
	 *
	 * @param genders the genders
	 */
	@Override
	public void cacheResult(List<Gender> genders) {
		for (Gender gender : genders) {
			if (entityCache.getResult(
					GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
					gender.getPrimaryKey()) == null) {

				cacheResult(gender);
			}
			else {
				gender.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all genders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GenderImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gender.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Gender gender) {
		entityCache.removeResult(
			GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
			gender.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Gender> genders) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Gender gender : genders) {
			entityCache.removeResult(
				GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
				gender.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new gender with the primary key. Does not add the gender to the database.
	 *
	 * @param genderId the primary key for the new gender
	 * @return the new gender
	 */
	@Override
	public Gender create(long genderId) {
		Gender gender = new GenderImpl();

		gender.setNew(true);
		gender.setPrimaryKey(genderId);

		return gender;
	}

	/**
	 * Removes the gender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender that was removed
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	@Override
	public Gender remove(long genderId) throws NoSuchGenderException {
		return remove((Serializable)genderId);
	}

	/**
	 * Removes the gender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gender
	 * @return the gender that was removed
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	@Override
	public Gender remove(Serializable primaryKey) throws NoSuchGenderException {
		Session session = null;

		try {
			session = openSession();

			Gender gender = (Gender)session.get(GenderImpl.class, primaryKey);

			if (gender == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGenderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gender);
		}
		catch (NoSuchGenderException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Gender removeImpl(Gender gender) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gender)) {
				gender = (Gender)session.get(
					GenderImpl.class, gender.getPrimaryKeyObj());
			}

			if (gender != null) {
				session.delete(gender);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gender != null) {
			clearCache(gender);
		}

		return gender;
	}

	@Override
	public Gender updateImpl(Gender gender) {
		boolean isNew = gender.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gender.isNew()) {
				session.save(gender);

				gender.setNew(false);
			}
			else {
				gender = (Gender)session.merge(gender);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
			gender.getPrimaryKey(), gender, false);

		gender.resetOriginalValues();

		return gender;
	}

	/**
	 * Returns the gender with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gender
	 * @return the gender
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	@Override
	public Gender findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGenderException {

		Gender gender = fetchByPrimaryKey(primaryKey);

		if (gender == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGenderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gender;
	}

	/**
	 * Returns the gender with the primary key or throws a <code>NoSuchGenderException</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	@Override
	public Gender findByPrimaryKey(long genderId) throws NoSuchGenderException {
		return findByPrimaryKey((Serializable)genderId);
	}

	/**
	 * Returns the gender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gender
	 * @return the gender, or <code>null</code> if a gender with the primary key could not be found
	 */
	@Override
	public Gender fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Gender gender = (Gender)serializable;

		if (gender == null) {
			Session session = null;

			try {
				session = openSession();

				gender = (Gender)session.get(GenderImpl.class, primaryKey);

				if (gender != null) {
					cacheResult(gender);
				}
				else {
					entityCache.putResult(
						GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return gender;
	}

	/**
	 * Returns the gender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender, or <code>null</code> if a gender with the primary key could not be found
	 */
	@Override
	public Gender fetchByPrimaryKey(long genderId) {
		return fetchByPrimaryKey((Serializable)genderId);
	}

	@Override
	public Map<Serializable, Gender> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Gender> map = new HashMap<Serializable, Gender>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Gender gender = fetchByPrimaryKey(primaryKey);

			if (gender != null) {
				map.put(primaryKey, gender);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Gender)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_GENDER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (Gender gender : (List<Gender>)query.list()) {
				map.put(gender.getPrimaryKeyObj(), gender);

				cacheResult(gender);

				uncachedPrimaryKeys.remove(gender.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					GenderModelImpl.ENTITY_CACHE_ENABLED, GenderImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the genders.
	 *
	 * @return the genders
	 */
	@Override
	public List<Gender> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @return the range of genders
	 */
	@Override
	public List<Gender> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of genders
	 */
	@Override
	public List<Gender> findAll(
		int start, int end, OrderByComparator<Gender> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the genders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GenderModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of genders
	 * @param end the upper bound of the range of genders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of genders
	 */
	@Override
	public List<Gender> findAll(
		int start, int end, OrderByComparator<Gender> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Gender> list = null;

		if (useFinderCache) {
			list = (List<Gender>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GENDER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GENDER;

				sql = sql.concat(GenderModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Gender>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the genders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Gender gender : findAll()) {
			remove(gender);
		}
	}

	/**
	 * Returns the number of genders.
	 *
	 * @return the number of genders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GENDER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GenderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gender persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			GenderModelImpl.ENTITY_CACHE_ENABLED,
			GenderModelImpl.FINDER_CACHE_ENABLED, GenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			GenderModelImpl.ENTITY_CACHE_ENABLED,
			GenderModelImpl.FINDER_CACHE_ENABLED, GenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			GenderModelImpl.ENTITY_CACHE_ENABLED,
			GenderModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(GenderImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GENDER =
		"SELECT gender FROM Gender gender";

	private static final String _SQL_SELECT_GENDER_WHERE_PKS_IN =
		"SELECT gender FROM Gender gender WHERE id IN (";

	private static final String _SQL_COUNT_GENDER =
		"SELECT COUNT(gender) FROM Gender gender";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gender.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Gender exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GenderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"genderId", "genderName"});

}