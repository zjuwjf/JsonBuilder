/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public interface IJBObjectFor<ParentType extends IJBAppend, T> {
	IJBObjectForIter<ParentType> it(IJBIter<T> iter);
}
