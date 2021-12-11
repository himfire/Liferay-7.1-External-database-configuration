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

package site.hadef.database2.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Region}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Region
 * @generated
 */
public class RegionWrapper implements ModelWrapper<Region>, Region {

	public RegionWrapper(Region region) {
		_region = region;
	}

	@Override
	public Class<?> getModelClass() {
		return Region.class;
	}

	@Override
	public String getModelClassName() {
		return Region.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Object clone() {
		return new RegionWrapper((Region)_region.clone());
	}

	@Override
	public int compareTo(site.hadef.database2.model.Region region) {
		return _region.compareTo(region);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _region.getExpandoBridge();
	}

	/**
	 * Returns the ID of this region.
	 *
	 * @return the ID of this region
	 */
	@Override
	public long getId() {
		return _region.getId();
	}

	/**
	 * Returns the name of this region.
	 *
	 * @return the name of this region
	 */
	@Override
	public String getName() {
		return _region.getName();
	}

	/**
	 * Returns the primary key of this region.
	 *
	 * @return the primary key of this region
	 */
	@Override
	public long getPrimaryKey() {
		return _region.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _region.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _region.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _region.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _region.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _region.isNew();
	}

	@Override
	public void persist() {
		_region.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_region.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_region.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_region.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_region.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this region.
	 *
	 * @param id the ID of this region
	 */
	@Override
	public void setId(long id) {
		_region.setId(id);
	}

	/**
	 * Sets the name of this region.
	 *
	 * @param name the name of this region
	 */
	@Override
	public void setName(String name) {
		_region.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_region.setNew(n);
	}

	/**
	 * Sets the primary key of this region.
	 *
	 * @param primaryKey the primary key of this region
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_region.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_region.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<site.hadef.database2.model.Region> toCacheModel() {

		return _region.toCacheModel();
	}

	@Override
	public site.hadef.database2.model.Region toEscapedModel() {
		return new RegionWrapper(_region.toEscapedModel());
	}

	@Override
	public String toString() {
		return _region.toString();
	}

	@Override
	public site.hadef.database2.model.Region toUnescapedModel() {
		return new RegionWrapper(_region.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _region.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegionWrapper)) {
			return false;
		}

		RegionWrapper regionWrapper = (RegionWrapper)object;

		if (Objects.equals(_region, regionWrapper._region)) {
			return true;
		}

		return false;
	}

	@Override
	public Region getWrappedModel() {
		return _region;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _region.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _region.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_region.resetOriginalValues();
	}

	private final Region _region;

}