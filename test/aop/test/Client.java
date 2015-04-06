/**
 * 
 */
package aop.test;

import java.util.ArrayList;
import java.util.List;

import colin.aop.AopProxy;
import colin.aop.JdkDynamicProxyFactory;
import colin.aop.handler.AbstractHandler;
import colin.aop.handler.LogAfter;
import colin.aop.handler.LogBefore;

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

		Sort sort = new HeapSort();

		AopProxy aopProxy = new JdkDynamicProxyFactory(sort, handlers);
		Sort sortProxy = (Sort) aopProxy.getProxy();
		Integer[] a = new Integer[] {10,13,6,5,1,9,12,42,14,6};
		sortProxy.sort(a);
		SortUtil.show(a);
	}

}
