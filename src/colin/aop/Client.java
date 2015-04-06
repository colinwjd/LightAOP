/**
 * 
 */
package colin.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractHandler before = new LogBefore();
		AbstractHandler after = new LogAfter();
		List<AbstractHandler> handlers = new ArrayList<AbstractHandler>(2);
		handlers.add(before);
		handlers.add(after);

		List<String> names = new ArrayList<>();
		names.add("Colin");
		names.add("Tony");
		names.add("Amy");

		AopProxy aopProxy = new JdkDynamicProxyFactory(names, handlers);
		List<String> proxy = (List<String>) aopProxy.getProxy();
		proxy.add("haha");
		proxy.clear();
	}

}
