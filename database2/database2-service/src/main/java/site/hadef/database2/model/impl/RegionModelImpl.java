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

package site.hadef.database2.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import site.hadef.database2.model.Region;
import site.hadef.database2.model.RegionModel;

/**
 * The base model implementation for the Region service. Represents a row in the &quot;region&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RegionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegionImpl
 * @generated
 */
public class RegionModelImpl
	extends BaseModelImpl<Region> implements RegionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a region model instance should use the <code>Region</code> interface instead.
	 */
	public static final String TABLE_NAME = "region";

	public static final Object[][] TABLE_COLUMNS = {
		{"id", Types.BIGINT}, {"name", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table region (id LONG not null primary key,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table region";

	public static final String ORDER_BY_JPQL = " ORDER BY region.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY region.id ASC";

	public static final String DATA_SOURCE = "extDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		site.hadef.database2.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.site.hadef.database2.model.Region"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		site.hadef.database2.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.site.hadef.database2.model.Region"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		site.hadef.database2.service.util.ServiceProps.get(
			"lock.expiration.time.site.hadef.database2.model.Region"));

	public RegionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Region)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Region, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Region, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Region)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Region, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Region, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Region>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Region.class.getClassLoader(), Region.class, ModelWrapper.class);

		try {
			Constructor<Region> constructor =
				(Constructor<Region>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Region, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Region, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Region, Object>>();
		Map<String, BiConsumer<Region, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Region, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object idObject) {
					region.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<Region, Object>() {

				@Override
				public Object apply(Region region) {
					return region.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<Region, Object>() {

				@Override
				public void accept(Region region, Object nameObject) {
					region.setName((String)nameObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Region.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Region toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Region>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegionImpl regionImpl = new RegionImpl();

		regionImpl.setId(getId());
		regionImpl.setName(getName());

		regionImpl.resetOriginalValues();

		return regionImpl;
	}

	@Override
	public int compareTo(Region region) {
		long primaryKey = region.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Region)) {
			return false;
		}

		Region region = (Region)object;

		long primaryKey = region.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Region> toCacheModel() {
		RegionCacheModel regionCacheModel = new RegionCacheModel();

		regionCacheModel.id = getId();

		regionCacheModel.name = getName();

		String name = regionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			regionCacheModel.name = null;
		}

		return regionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Region)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Region, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Region, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Region, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Region)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Region>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _id;
	private String _name;
	private Region _escapedModel;

}