/**
 *
 */
package com.wjs.jb.imp;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBAppend extends IJBBase{
	//not public, not protected
	abstract void append(String key, Object value);
}
