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
public abstract class BeforeHandler extends AbstractHandler {

	protected abstract void before(Object proxy, Method method, Object[] args);

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before(proxy, method, args);
		return method.invoke(getTarget(), args);
	}
	
	
}
