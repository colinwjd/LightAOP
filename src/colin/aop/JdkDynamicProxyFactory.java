package colin.aop;

import java.lang.reflect.Proxy;
import java.util.List;

import colin.aop.handler.AbstractHandler;

/**
 * 
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public class JdkDynamicProxyFactory implements AopProxy {

	private Object target;
	private List<AbstractHandler> handlers;

	public JdkDynamicProxyFactory(Object target, List<AbstractHandler> handlers) {
		this.target = target;
		this.handlers = handlers;
	}

	@Override
	public Object getProxy() {
		return doGetProxy();
	}

	private Object doGetProxy() {
		if (handlers.size() > 0) {
			Object proxy = target;
			for (int i = 0; i < handlers.size(); i++) {
				handlers.get(i).setTarget(proxy);
				proxy = Proxy.newProxyInstance(target.getClass()
						.getClassLoader(), target.getClass().getInterfaces(),
						handlers.get(i));
			}
			return proxy;
		} else {
			return target;
		}
	}
}
