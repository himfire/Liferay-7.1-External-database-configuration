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

package site.hadef.database3.model.impl;

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

import site.hadef.database3.model.Gender;
import site.hadef.database3.model.GenderModel;

/**
 * The base model implementation for the Gender service. Represents a row in the &quot;gender&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>GenderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GenderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GenderImpl
 * @generated
 */
public class GenderModelImpl
	extends BaseModelImpl<Gender> implements GenderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gender model instance should use the <code>Gender</code> interface instead.
	 */
	public static final String TABLE_NAME = "gender";

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
		"create table gender (id LONG not null primary key,name VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gender";

	public static final String ORDER_BY_JPQL = " ORDER BY gender.genderId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY gender.id ASC";

	public static final String DATA_SOURCE = "extDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		site.hadef.database3.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.site.hadef.database3.model.Gender"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		site.hadef.database3.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.site.hadef.database3.model.Gender"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		site.hadef.database3.service.util.ServiceProps.get(
			"lock.expiration.time.site.hadef.database3.model.Gender"));

	public GenderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _genderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGenderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _genderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Gender)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Gender, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Gender, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Gender)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Gender, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Gender, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Gender>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Gender.class.getClassLoader(), Gender.class, ModelWrapper.class);

		try {
			Constructor<Gender> constructor =
				(Constructor<Gender>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Gender, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Gender, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Gender, Object>>();
		Map<String, BiConsumer<Gender, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Gender, ?>>();

		attributeGetterFunctions.put(
			"genderId",
			new Function<Gender, Object>() {

				@Override
				public Object apply(Gender gender) {
					return gender.getGenderId();
				}

			});
		attributeSetterBiConsumers.put(
			"genderId",
			new BiConsumer<Gender, Object>() {

				@Override
				public void accept(Gender gender, Object genderIdObject) {
					gender.setGenderId((Long)genderIdObject);
				}

			});
		attributeGetterFunctions.put(
			"genderName",
			new Function<Gender, Object>() {

				@Override
				public Object apply(Gender gender) {
					return gender.getGenderName();
				}

			});
		attributeSetterBiConsumers.put(
			"genderName",
			new BiConsumer<Gender, Object>() {

				@Override
				public void accept(Gender gender, Object genderNameObject) {
					gender.setGenderName((String)genderNameObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getGenderId() {
		return _genderId;
	}

	@Override
	public void setGenderId(long genderId) {
		_genderId = genderId;
	}

	@Override
	public String getGenderName() {
		if (_genderName == null) {
			return "";
		}
		else {
			return _genderName;
		}
	}

	@Override
	public void setGenderName(String genderName) {
		_genderName = genderName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Gender.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Gender toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Gender>
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
		GenderImpl genderImpl = new GenderImpl();

		genderImpl.setGenderId(getGenderId());
		genderImpl.setGenderName(getGenderName());

		genderImpl.resetOriginalValues();

		return genderImpl;
	}

	@Override
	public int compareTo(Gender gender) {
		long primaryKey = gender.getPrimaryKey();

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

		if (!(object instanceof Gender)) {
			return false;
		}

		Gender gender = (Gender)object;

		long primaryKey = gender.getPrimaryKey();

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
	public CacheModel<Gender> toCacheModel() {
		GenderCacheModel genderCacheModel = new GenderCacheModel();

		genderCacheModel.genderId = getGenderId();

		genderCacheModel.genderName = getGenderName();

		String genderName = genderCacheModel.genderName;

		if ((genderName != null) && (genderName.length() == 0)) {
			genderCacheModel.genderName = null;
		}

		return genderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Gender)this));
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
		Map<String, Function<Gender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Gender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Gender, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Gender)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Gender>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _genderId;
	private String _genderName;
	private Gender _escapedModel;

}