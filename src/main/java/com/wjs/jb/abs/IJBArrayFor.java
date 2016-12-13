/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.imp.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBArrayFor<ParentType extends IJBAppend, T> {

	IJBArrayForIter<ParentType> it(IJBArrayIter<T> iter);

	IJBArrayForIter<ParentType> it();
}
