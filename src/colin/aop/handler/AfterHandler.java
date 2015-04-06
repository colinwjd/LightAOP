/**
 * 
 */
package colin.aop.handler;

import java.lang.reflect.Method;

/**
 * 
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public abstract class AfterHandler extends AbstractHandler {

	protected abstract void after(Object proxy, Method method, Object[] args);

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(getTarget(), args);
		after(proxy, method, args);
		return result;
	}

}
