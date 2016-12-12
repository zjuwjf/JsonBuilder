/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public interface IJBArrayFor<ParentType extends IJBAppend, T> {

	IJBArrayForIter<ParentType> it(IJBIter<T> iter);

	IJBArrayForIter<ParentType> it();
}
