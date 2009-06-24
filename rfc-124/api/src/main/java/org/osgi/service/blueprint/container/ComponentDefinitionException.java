/*
 * Copyright (c) OSGi Alliance (2008, 2009). All Rights Reserved.
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
package org.osgi.service.blueprint.container;

/**
 * Exception thrown when a configuration-related error occurs during creation of
 * a module context.
 */
public class ComponentDefinitionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a <code>ComponentDefinitionException</code> with no message or
	 * exception cause.
	 */
	public ComponentDefinitionException() {
		super();
	}

	/**
	 * Creates a <code>ComponentDefinitionException</code> with the specified
	 * message
	 * 
	 * @param explanation
	 *            The associated message.
	 */
	public ComponentDefinitionException(String explanation) {
		super(explanation);
	}

	/**
	 * Creates a <code>ComponentDefinitionException</code> with the specified
	 * message and exception cause.
	 * 
	 * @param explanation
	 *            The associated message.
	 * @param cause
	 *            The cause of this exception.
	 */
	public ComponentDefinitionException(String explanation, Throwable cause) {
		super(explanation, cause);
	}

	/**
	 * Creates a <code>ComponentDefinitionException</code> with the exception
	 * cause.
	 * 
	 * @param cause
	 *            The cause of this exception.
	 */
	public ComponentDefinitionException(Throwable cause) {
		super(cause);
	}

}