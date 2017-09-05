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

package org.opencps.backend.dossiermgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ServiceOption service. Represents a row in the &quot;opencps_serviceoption&quot; database table, with each column mapped to a property of this class.
 *
 * @author huymq
 * @see ServiceOptionModel
 * @see org.opencps.backend.dossiermgt.model.impl.ServiceOptionImpl
 * @see org.opencps.backend.dossiermgt.model.impl.ServiceOptionModelImpl
 * @generated
 */
@ImplementationClassName("org.opencps.backend.dossiermgt.model.impl.ServiceOptionImpl")
@ProviderType
public interface ServiceOption extends ServiceOptionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.opencps.backend.dossiermgt.model.impl.ServiceOptionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ServiceOption, Long> SERVICE_OPTION_ID_ACCESSOR =
		new Accessor<ServiceOption, Long>() {
			@Override
			public Long get(ServiceOption serviceOption) {
				return serviceOption.getServiceOptionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ServiceOption> getTypeClass() {
				return ServiceOption.class;
			}
		};
}