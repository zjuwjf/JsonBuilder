/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.JBEntry;

/**
 * @author zju_wjf
 * @date 2016年12月10日
 */
public interface IJBIter<T> {
	/**
	 * @author zju_wjf
	 * @date 2016年12月11日
	 * @param index
	 * @param t
	 * @return
	 */
	JBEntry iter(int index, T t);
}
