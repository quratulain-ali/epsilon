/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.concurrent;

import java.util.function.Supplier;

/**
 * Utility class which allows for co-ordinating concurrent execution with waiting
 * semantics for successful and exceptional completion. This class is only suitable
 * for single-condition locking, where there is only one success condition registered
 * at any given time. Multiple conditions can be supported using serial thread confinement
 * or {@link MultiConcurrentExecutionStatus}.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public final class SingleConcurrentExecutionStatus extends ConcurrentExecutionStatus {
	
	private volatile boolean inProgress = false;
	private volatile boolean registerAvailable = true;
	private Object result;
	private Object currentLock;

	@Override
	public Object getResult(Object lockObj) {
		return result;
	}
	
	@Override
	public boolean register(Object lockObj) {
		if (registerAvailable) {
			assert !inProgress;
			inProgress = true;
			registerAvailable = false;
			return true;
		}
		else {
			assert inProgress;
			return false;
		}
	}
	
	@Override
	public boolean isInProgress(Object lockObj) {
		return inProgress;
	}
	
	private void complete(Object lockObj) {
		inProgress = false;
		if (lockObj != null) synchronized (lockObj) {
			lockObj.notifyAll();
		}
		else if (currentLock != lockObj) synchronized (currentLock) {
			currentLock.notifyAll();
		}
		currentLock = null;
		registerAvailable = true;
	}
	
	@Override
	public void completeSuccessfully(Object lockObj) {
		complete(lockObj);
	}
	
	@Override
	public void completeWithResult(Object lockObj, Object result) {
		this.result = result;
		completeSuccessfully(lockObj);
	}
	
	@Override
	public void completeExceptionally(Throwable exception) {
		completeExceptionallyBase(exception);
		complete(currentLock);
	}
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	@Override
	public boolean waitForCompletion(final Object lockObj, final Supplier<Boolean> targetState) {
		assert lockObj != null;
		currentLock = lockObj;
		while (isInProgress(lockObj) && (targetState == null || !targetState.get())) synchronized (lockObj) {
			try {
				// Don't wait forever just in case someone forgets to notify or interrupt
				lockObj.wait(Short.MAX_VALUE);
			}
			catch (InterruptedException ie) {}
		}
		currentLock = null;
		return !failed;
	}
	
	/*@Override
	public Exception waitForExceptionalCompletion() {
		waitForCompletion(lockObj, () -> failed);
		return exception;
	}*/
}