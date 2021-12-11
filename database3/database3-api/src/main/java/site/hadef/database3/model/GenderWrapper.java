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

package site.hadef.database3.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Gender}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Gender
 * @generated
 */
public class GenderWrapper implements Gender, ModelWrapper<Gender> {

	public GenderWrapper(Gender gender) {
		_gender = gender;
	}

	@Override
	public Class<?> getModelClass() {
		return Gender.class;
	}

	@Override
	public String getModelClassName() {
		return Gender.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genderId", getGenderId());
		attributes.put("genderName", getGenderName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genderId = (Long)attributes.get("genderId");

		if (genderId != null) {
			setGenderId(genderId);
		}

		String genderName = (String)attributes.get("genderName");

		if (genderName != null) {
			setGenderName(genderName);
		}
	}

	@Override
	public Object clone() {
		return new GenderWrapper((Gender)_gender.clone());
	}

	@Override
	public int compareTo(site.hadef.database3.model.Gender gender) {
		return _gender.compareTo(gender);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _gender.getExpandoBridge();
	}

	/**
	 * Returns the gender ID of this gender.
	 *
	 * @return the gender ID of this gender
	 */
	@Override
	public long getGenderId() {
		return _gender.getGenderId();
	}

	/**
	 * Returns the gender name of this gender.
	 *
	 * @return the gender name of this gender
	 */
	@Override
	public String getGenderName() {
		return _gender.getGenderName();
	}

	/**
	 * Returns the primary key of this gender.
	 *
	 * @return the primary key of this gender
	 */
	@Override
	public long getPrimaryKey() {
		return _gender.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gender.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _gender.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _gender.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _gender.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _gender.isNew();
	}

	@Override
	public void persist() {
		_gender.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gender.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_gender.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_gender.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_gender.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the gender ID of this gender.
	 *
	 * @param genderId the gender ID of this gender
	 */
	@Override
	public void setGenderId(long genderId) {
		_gender.setGenderId(genderId);
	}

	/**
	 * Sets the gender name of this gender.
	 *
	 * @param genderName the gender name of this gender
	 */
	@Override
	public void setGenderName(String genderName) {
		_gender.setGenderName(genderName);
	}

	@Override
	public void setNew(boolean n) {
		_gender.setNew(n);
	}

	/**
	 * Sets the primary key of this gender.
	 *
	 * @param primaryKey the primary key of this gender
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gender.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_gender.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<site.hadef.database3.model.Gender> toCacheModel() {

		return _gender.toCacheModel();
	}

	@Override
	public site.hadef.database3.model.Gender toEscapedModel() {
		return new GenderWrapper(_gender.toEscapedModel());
	}

	@Override
	public String toString() {
		return _gender.toString();
	}

	@Override
	public site.hadef.database3.model.Gender toUnescapedModel() {
		return new GenderWrapper(_gender.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _gender.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GenderWrapper)) {
			return false;
		}

		GenderWrapper genderWrapper = (GenderWrapper)object;

		if (Objects.equals(_gender, genderWrapper._gender)) {
			return true;
		}

		return false;
	}

	@Override
	public Gender getWrappedModel() {
		return _gender;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _gender.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _gender.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_gender.resetOriginalValues();
	}

	private final Gender _gender;

}