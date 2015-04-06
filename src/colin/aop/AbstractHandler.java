/**
 * 
 */
package colin.aop;

import java.lang.reflect.InvocationHandler;

/**
 * 
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public abstract class AbstractHandler implements InvocationHandler {

	private Object target;

	protected void setTarget(Object target) {
		this.target = target;
	}

	public Object getTarget() {
		return this.target;
	}

}
