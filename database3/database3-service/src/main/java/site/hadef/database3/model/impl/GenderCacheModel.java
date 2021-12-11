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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import site.hadef.database3.model.Gender;

/**
 * The cache model class for representing Gender in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GenderCacheModel implements CacheModel<Gender>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GenderCacheModel)) {
			return false;
		}

		GenderCacheModel genderCacheModel = (GenderCacheModel)object;

		if (genderId == genderCacheModel.genderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, genderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{genderId=");
		sb.append(genderId);
		sb.append(", genderName=");
		sb.append(genderName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Gender toEntityModel() {
		GenderImpl genderImpl = new GenderImpl();

		genderImpl.setGenderId(genderId);

		if (genderName == null) {
			genderImpl.setGenderName("");
		}
		else {
			genderImpl.setGenderName(genderName);
		}

		genderImpl.resetOriginalValues();

		return genderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		genderId = objectInput.readLong();
		genderName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(genderId);

		if (genderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(genderName);
		}
	}

	public long genderId;
	public String genderName;

}