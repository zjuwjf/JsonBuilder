/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.imp.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBObjectForIter<GrandParentType extends IJBAppend> {
	GrandParentType efor();
}
