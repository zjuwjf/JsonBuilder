/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.JBEntry;

/**
 * @author zju_wjf
 * @date 2016年12月10日
 */
public interface IJBFilter {
	/**
	 * if true then include, else exclude
	 * @author zju_wjf
	 * @date 2016年12月10日
	 * @param entry
	 * @return
	 */
	boolean filter( JBEntry entry );
}
