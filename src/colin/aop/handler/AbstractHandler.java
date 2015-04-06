/**
 * 
 */
package colin.aop.handler;

import java.lang.reflect.InvocationHandler;

/**
 * 
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public abstract class AbstractHandler implements InvocationHandler {

	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getTarget() {
		return this.target;
	}

}
