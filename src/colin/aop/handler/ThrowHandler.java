/**
 * 
 */
package colin.aop.handler;

import java.lang.reflect.Method;

/**
 * @author Colin Wang
 * @date Apr 7, 2015
 */
public abstract class ThrowHandler extends AbstractHandler {

	protected abstract void whenThrow(Object proxy, Method method, Object[] args);
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		try {
			result = method.invoke(getTarget(), args);
		} catch (Throwable t) {
			whenThrow(proxy, method, args);
			throw t;
		}
		return result;
	}

}
