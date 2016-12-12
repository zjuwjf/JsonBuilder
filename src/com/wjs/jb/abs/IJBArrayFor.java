/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBArrayFor<ParentType extends IJBAppend, T> {

	IJBArrayForIter<ParentType> it(IJBIter<T> iter);

	IJBArrayForIter<ParentType> it();
}
