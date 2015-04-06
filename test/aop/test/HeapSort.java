/**
 * 
 */
package aop.test;


/**
 * @author Colin Wang
 * @date Apr 6, 2015
 */
public class HeapSort implements Sort {

	@SuppressWarnings("rawtypes")
	@Override
	public void sort(Comparable[] a) {
		int size = a.length;
		// 先建立堆
		for (int i = size / 2; i > 0; i--) {
			sink(a, i, size);
		}
		// 把堆顶（当前最大元素）跟堆尾交换
		// 然后将堆的大小缩小1，整个数组从后向前逐步有序
		while (size > 1) {
			// 由于堆没有使用a[0]，所以当读或者写数组时
			// 实际操作的数组下标应当比堆操作的下标值少1
			// 相当于建立一个映射：堆中的1,2,3,4...对应数组中的0,1,2,3...
			SortUtil.swap(a, 0, size - 1);
			size--;
			sink(a, 1, size);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void sink(Comparable[] a, int k, int size) {
		while (2 * k <= size) {
			int child = k << 1;
			if (child < size && SortUtil.less(a[child - 1], a[child])) {
				child++;
			}
			if (!SortUtil.less(a[k - 1], a[child - 1])) {
				break;
			}
			SortUtil.swap(a, k - 1, child - 1);
			k = child;
		}
	}

}
