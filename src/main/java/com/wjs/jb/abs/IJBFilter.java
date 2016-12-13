/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.imp.JBEntry;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBFilter {
	/**
	 * if true then include, else exclude
	 * @author zju_wjf
	 * @date 2016��12��10��
	 * @param entry
	 * @return
	 */
	boolean filter( JBEntry entry );
}
