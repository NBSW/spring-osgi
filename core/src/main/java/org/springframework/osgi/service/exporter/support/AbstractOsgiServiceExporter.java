/*
 * Copyright 2006-2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.osgi.service.exporter.support;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.osgi.framework.ServiceRegistration;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.osgi.service.exporter.OsgiServiceRegistrationListener;
import org.springframework.osgi.service.exporter.support.internal.support.ListenerNotifier;
import org.springframework.osgi.service.exporter.support.internal.support.ServiceRegistrationDecorator;

/**
 * Base exporter class providing common functionality for registering (also known as exporting) Spring beans as OSGi
 * services.
 * 
 * @author Costin Leau
 */
abstract class AbstractOsgiServiceExporter implements DisposableBean {

	/** listeners */
	private OsgiServiceRegistrationListener[] listeners = new OsgiServiceRegistrationListener[0];
	/** lazy callbacks */
	private boolean lazyListeners = false;
	private ListenerNotifier notifier;

	ListenerNotifier getNotifier() {
		return notifier;
	}

	/**
	 * Sets the listeners interested in registration and unregistration events.
	 * 
	 * @param listeners registration/unregistration listeners.
	 */
	public void setListeners(OsgiServiceRegistrationListener[] listeners) {
		if (listeners != null) {
			this.listeners = listeners;
			this.notifier = new ListenerNotifier(listeners);
		}
	}

	public void destroy() {
		unregisterService();
	}

	/**
	 * Registers/Exports the OSGi service.
	 */
	abstract void registerService();

	/**
	 * Unregisters/de-exports the OSGi service.
	 */
	abstract void unregisterService();

	/**
	 * Sets the laziness of the exporter listeners. Eager listeners (default) will cause the listeners to be called when
	 * the service is being exported. In contract, if true is passed, the listeners will be called not when the service
	 * is registered but after the first bundle actually requests it or another component requests the service
	 * registration. "Lazy listeners" are the equivalent of lazy activated service managers in Blueprint Service (OSGi
	 * 4.2).
	 * 
	 * @param lazyListeners false if the listeners should be called when the service is registered, true if the
	 * invocations should occur after the first service/factory bean request
	 */
	public void setLazyListeners(boolean lazyListeners) {
		this.lazyListeners = lazyListeners;
	}

	public boolean getLazyListeners() {
		return lazyListeners;
	}
}