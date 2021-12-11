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

package site.hadef.database3.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import site.hadef.database3.model.Gender;

/**
 * The persistence utility for the gender service. This utility wraps <code>site.hadef.database3.service.persistence.impl.GenderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderPersistence
 * @generated
 */
public class GenderUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Gender gender) {
		getPersistence().clearCache(gender);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Gender> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Gender> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Gender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Gender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Gender> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Gender update(Gender gender) {
		return getPersistence().update(gender);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Gender update(Gender gender, ServiceContext serviceContext) {
		return getPersistence().update(gender, serviceContext);
	}

	/**
	 * Caches the gender in the entity cache if it is enabled.
	 *
	 * @param gender the gender
	 */
	public static void cacheResult(Gender gender) {
		getPersistence().cacheResult(gender);
	}

	/**
	 * Caches the genders in the entity cache if it is enabled.
	 *
	 * @param genders the genders
	 */
	public static void cacheResult(List<Gender> genders) {
		getPersistence().cacheResult(genders);
	}

	/**
	 * Creates a new gender with the primary key. Does not add the gender to the database.
	 *
	 * @param genderId the primary key for the new gender
	 * @return the new gender
	 */
	public static Gender create(long genderId) {
		return getPersistence().create(genderId);
	}

	/**
	 * Removes the gender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender that was removed
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	public static Gender remove(long genderId)
		throws site.hadef.database3.exception.NoSuchGenderException {

		return getPersistence().remove(genderId);
	}

	public static Gender updateImpl(Gender gender) {
		return getPersistence().updateImpl(gender);
	}

	/**
	 * Returns the gender with the primary key or throws a <code>NoSuchGenderException</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender
	 * @throws NoSuchGenderException if a gender with the primary key could not be found
	 */
	public static Gender findByPrimaryKey(long genderId)
		throws site.hadef.database3.exception.NoSuchGenderException {

		return getPersistence().findByPrimaryKey(genderId);
	}

	/**
	 * Returns the gender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genderId the primary key of the gender
	 * @return the gender, or <code>null</code> if a gender with the primary key could not be found
	 */
	public static Gender fetchByPrimaryKey(long genderId) {
		return getPersistence().fetchByPrimaryKey(genderId);
	}

	/**
	 * Returns all the genders.
	 *
	 * @return the genders
	 */
	public static List<Gender> findAll() {
		return getPersistence().findAll();
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
	public static List<Gender> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Gender> findAll(
		int start, int end, OrderByComparator<Gender> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Gender> findAll(
		int start, int end, OrderByComparator<Gender> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the genders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of genders.
	 *
	 * @return the number of genders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GenderPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GenderPersistence, GenderPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GenderPersistence.class);

		ServiceTracker<GenderPersistence, GenderPersistence> serviceTracker =
			new ServiceTracker<GenderPersistence, GenderPersistence>(
				bundle.getBundleContext(), GenderPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}