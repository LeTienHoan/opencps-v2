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

package org.opencps.backend.processmgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.opencps.backend.processmgt.model.ProcessStep;
import org.opencps.backend.processmgt.model.ProcessStepModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ProcessStep service. Represents a row in the &quot;opencps_processstep&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ProcessStepModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcessStepImpl}.
 * </p>
 *
 * @author khoavu
 * @see ProcessStepImpl
 * @see ProcessStep
 * @see ProcessStepModel
 * @generated
 */
@ProviderType
public class ProcessStepModelImpl extends BaseModelImpl<ProcessStep>
	implements ProcessStepModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a process step model instance should use the {@link ProcessStep} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_processstep";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "processStepId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "stepCode", Types.VARCHAR },
			{ "serviceProcessId", Types.BIGINT },
			{ "stepName", Types.VARCHAR },
			{ "sequenceNo", Types.VARCHAR },
			{ "dossierStatus", Types.VARCHAR },
			{ "dossierSubStatus", Types.VARCHAR },
			{ "durationCount", Types.INTEGER },
			{ "customProcessUrl", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("processStepId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("stepCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceProcessId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("stepName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sequenceNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dossierSubStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("durationCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("customProcessUrl", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_processstep (uuid_ VARCHAR(75) null,processStepId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,stepCode VARCHAR(75) null,serviceProcessId LONG,stepName VARCHAR(75) null,sequenceNo VARCHAR(75) null,dossierStatus VARCHAR(75) null,dossierSubStatus VARCHAR(75) null,durationCount INTEGER,customProcessUrl VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_processstep";
	public static final String ORDER_BY_JPQL = " ORDER BY processStep.processStepId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_processstep.processStepId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.processmgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.backend.processmgt.model.ProcessStep"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.processmgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.backend.processmgt.model.ProcessStep"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.processmgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.backend.processmgt.model.ProcessStep"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long SERVICEPROCESSID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long PROCESSSTEPID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.processmgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.backend.processmgt.model.ProcessStep"));

	public ProcessStepModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _processStepId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessStepId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processStepId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessStep.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessStep.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("processStepId", getProcessStepId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("stepCode", getStepCode());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("stepName", getStepName());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("dossierSubStatus", getDossierSubStatus());
		attributes.put("durationCount", getDurationCount());
		attributes.put("customProcessUrl", getCustomProcessUrl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String stepCode = (String)attributes.get("stepCode");

		if (stepCode != null) {
			setStepCode(stepCode);
		}

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		String stepName = (String)attributes.get("stepName");

		if (stepName != null) {
			setStepName(stepName);
		}

		String sequenceNo = (String)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String dossierStatus = (String)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		String dossierSubStatus = (String)attributes.get("dossierSubStatus");

		if (dossierSubStatus != null) {
			setDossierSubStatus(dossierSubStatus);
		}

		Integer durationCount = (Integer)attributes.get("durationCount");

		if (durationCount != null) {
			setDurationCount(durationCount);
		}

		String customProcessUrl = (String)attributes.get("customProcessUrl");

		if (customProcessUrl != null) {
			setCustomProcessUrl(customProcessUrl);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getProcessStepId() {
		return _processStepId;
	}

	@Override
	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getStepCode() {
		if (_stepCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _stepCode;
		}
	}

	@Override
	public void setStepCode(String stepCode) {
		_stepCode = stepCode;
	}

	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_columnBitmask |= SERVICEPROCESSID_COLUMN_BITMASK;

		if (!_setOriginalServiceProcessId) {
			_setOriginalServiceProcessId = true;

			_originalServiceProcessId = _serviceProcessId;
		}

		_serviceProcessId = serviceProcessId;
	}

	public long getOriginalServiceProcessId() {
		return _originalServiceProcessId;
	}

	@Override
	public String getStepName() {
		if (_stepName == null) {
			return StringPool.BLANK;
		}
		else {
			return _stepName;
		}
	}

	@Override
	public void setStepName(String stepName) {
		_stepName = stepName;
	}

	@Override
	public String getSequenceNo() {
		if (_sequenceNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _sequenceNo;
		}
	}

	@Override
	public void setSequenceNo(String sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	@Override
	public String getDossierStatus() {
		if (_dossierStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierStatus;
		}
	}

	@Override
	public void setDossierStatus(String dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	@Override
	public String getDossierSubStatus() {
		if (_dossierSubStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _dossierSubStatus;
		}
	}

	@Override
	public void setDossierSubStatus(String dossierSubStatus) {
		_dossierSubStatus = dossierSubStatus;
	}

	@Override
	public int getDurationCount() {
		return _durationCount;
	}

	@Override
	public void setDurationCount(int durationCount) {
		_durationCount = durationCount;
	}

	@Override
	public String getCustomProcessUrl() {
		if (_customProcessUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _customProcessUrl;
		}
	}

	@Override
	public void setCustomProcessUrl(String customProcessUrl) {
		_customProcessUrl = customProcessUrl;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ProcessStep.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ProcessStep.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProcessStep toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ProcessStep)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProcessStepImpl processStepImpl = new ProcessStepImpl();

		processStepImpl.setUuid(getUuid());
		processStepImpl.setProcessStepId(getProcessStepId());
		processStepImpl.setCompanyId(getCompanyId());
		processStepImpl.setGroupId(getGroupId());
		processStepImpl.setUserId(getUserId());
		processStepImpl.setUserName(getUserName());
		processStepImpl.setCreateDate(getCreateDate());
		processStepImpl.setModifiedDate(getModifiedDate());
		processStepImpl.setStepCode(getStepCode());
		processStepImpl.setServiceProcessId(getServiceProcessId());
		processStepImpl.setStepName(getStepName());
		processStepImpl.setSequenceNo(getSequenceNo());
		processStepImpl.setDossierStatus(getDossierStatus());
		processStepImpl.setDossierSubStatus(getDossierSubStatus());
		processStepImpl.setDurationCount(getDurationCount());
		processStepImpl.setCustomProcessUrl(getCustomProcessUrl());

		processStepImpl.resetOriginalValues();

		return processStepImpl;
	}

	@Override
	public int compareTo(ProcessStep processStep) {
		long primaryKey = processStep.getPrimaryKey();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStep)) {
			return false;
		}

		ProcessStep processStep = (ProcessStep)obj;

		long primaryKey = processStep.getPrimaryKey();

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
		ProcessStepModelImpl processStepModelImpl = this;

		processStepModelImpl._originalUuid = processStepModelImpl._uuid;

		processStepModelImpl._originalCompanyId = processStepModelImpl._companyId;

		processStepModelImpl._setOriginalCompanyId = false;

		processStepModelImpl._originalGroupId = processStepModelImpl._groupId;

		processStepModelImpl._setOriginalGroupId = false;

		processStepModelImpl._setModifiedDate = false;

		processStepModelImpl._originalServiceProcessId = processStepModelImpl._serviceProcessId;

		processStepModelImpl._setOriginalServiceProcessId = false;

		processStepModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProcessStep> toCacheModel() {
		ProcessStepCacheModel processStepCacheModel = new ProcessStepCacheModel();

		processStepCacheModel.uuid = getUuid();

		String uuid = processStepCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			processStepCacheModel.uuid = null;
		}

		processStepCacheModel.processStepId = getProcessStepId();

		processStepCacheModel.companyId = getCompanyId();

		processStepCacheModel.groupId = getGroupId();

		processStepCacheModel.userId = getUserId();

		processStepCacheModel.userName = getUserName();

		String userName = processStepCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			processStepCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			processStepCacheModel.createDate = createDate.getTime();
		}
		else {
			processStepCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			processStepCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			processStepCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		processStepCacheModel.stepCode = getStepCode();

		String stepCode = processStepCacheModel.stepCode;

		if ((stepCode != null) && (stepCode.length() == 0)) {
			processStepCacheModel.stepCode = null;
		}

		processStepCacheModel.serviceProcessId = getServiceProcessId();

		processStepCacheModel.stepName = getStepName();

		String stepName = processStepCacheModel.stepName;

		if ((stepName != null) && (stepName.length() == 0)) {
			processStepCacheModel.stepName = null;
		}

		processStepCacheModel.sequenceNo = getSequenceNo();

		String sequenceNo = processStepCacheModel.sequenceNo;

		if ((sequenceNo != null) && (sequenceNo.length() == 0)) {
			processStepCacheModel.sequenceNo = null;
		}

		processStepCacheModel.dossierStatus = getDossierStatus();

		String dossierStatus = processStepCacheModel.dossierStatus;

		if ((dossierStatus != null) && (dossierStatus.length() == 0)) {
			processStepCacheModel.dossierStatus = null;
		}

		processStepCacheModel.dossierSubStatus = getDossierSubStatus();

		String dossierSubStatus = processStepCacheModel.dossierSubStatus;

		if ((dossierSubStatus != null) && (dossierSubStatus.length() == 0)) {
			processStepCacheModel.dossierSubStatus = null;
		}

		processStepCacheModel.durationCount = getDurationCount();

		processStepCacheModel.customProcessUrl = getCustomProcessUrl();

		String customProcessUrl = processStepCacheModel.customProcessUrl;

		if ((customProcessUrl != null) && (customProcessUrl.length() == 0)) {
			processStepCacheModel.customProcessUrl = null;
		}

		return processStepCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", processStepId=");
		sb.append(getProcessStepId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", stepCode=");
		sb.append(getStepCode());
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", stepName=");
		sb.append(getStepName());
		sb.append(", sequenceNo=");
		sb.append(getSequenceNo());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", dossierSubStatus=");
		sb.append(getDossierSubStatus());
		sb.append(", durationCount=");
		sb.append(getDurationCount());
		sb.append(", customProcessUrl=");
		sb.append(getCustomProcessUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.opencps.backend.processmgt.model.ProcessStep");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepCode</column-name><column-value><![CDATA[");
		sb.append(getStepCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepName</column-name><column-value><![CDATA[");
		sb.append(getStepName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNo</column-name><column-value><![CDATA[");
		sb.append(getSequenceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierSubStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierSubStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>durationCount</column-name><column-value><![CDATA[");
		sb.append(getDurationCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customProcessUrl</column-name><column-value><![CDATA[");
		sb.append(getCustomProcessUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ProcessStep.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ProcessStep.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _processStepId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _stepCode;
	private long _serviceProcessId;
	private long _originalServiceProcessId;
	private boolean _setOriginalServiceProcessId;
	private String _stepName;
	private String _sequenceNo;
	private String _dossierStatus;
	private String _dossierSubStatus;
	private int _durationCount;
	private String _customProcessUrl;
	private long _columnBitmask;
	private ProcessStep _escapedModel;
}