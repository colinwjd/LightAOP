/**
 * 
 */
package colin.aop;

import java.lang.reflect.Method;

/**
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public class LogBefore extends BeforeHandler {

	@Override
	protected void before(Object proxy, Method method, Object[] args) {
		String methodName = method.getName();
		System.out.println("Logging: Before method: " + methodName);
	}

}
