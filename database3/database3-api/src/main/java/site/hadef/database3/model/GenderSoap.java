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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GenderSoap implements Serializable {

	public static GenderSoap toSoapModel(Gender model) {
		GenderSoap soapModel = new GenderSoap();

		soapModel.setGenderId(model.getGenderId());
		soapModel.setGenderName(model.getGenderName());

		return soapModel;
	}

	public static GenderSoap[] toSoapModels(Gender[] models) {
		GenderSoap[] soapModels = new GenderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GenderSoap[][] toSoapModels(Gender[][] models) {
		GenderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GenderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GenderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GenderSoap[] toSoapModels(List<Gender> models) {
		List<GenderSoap> soapModels = new ArrayList<GenderSoap>(models.size());

		for (Gender model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GenderSoap[soapModels.size()]);
	}

	public GenderSoap() {
	}

	public long getPrimaryKey() {
		return _genderId;
	}

	public void setPrimaryKey(long pk) {
		setGenderId(pk);
	}

	public long getGenderId() {
		return _genderId;
	}

	public void setGenderId(long genderId) {
		_genderId = genderId;
	}

	public String getGenderName() {
		return _genderName;
	}

	public void setGenderName(String genderName) {
		_genderName = genderName;
	}

	private long _genderId;
	private String _genderName;

}