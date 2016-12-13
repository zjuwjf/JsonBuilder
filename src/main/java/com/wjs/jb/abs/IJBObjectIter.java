/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.JBEntry;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBObjectIter<T> {
	/**
	 * @author zju_wjf
	 * @date 2016��12��11��
	 * @param index
	 * @param t
	 * @return
	 */
	JBEntry iter(int index, T t);
}
