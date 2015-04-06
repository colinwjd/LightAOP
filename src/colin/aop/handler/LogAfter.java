/**
 * 
 */
package colin.aop.handler;

import java.lang.reflect.Method;

/**
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public class LogAfter extends AfterHandler {

	@Override
	protected void after(Object proxy, Method method, Object[] args) {
		String methodName = method.getName();
		System.out.println("Logging: After method: " + methodName);
	}

}
