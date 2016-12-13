/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBKeyIfPrepareEnd<Parent extends IJBAppend> extends IJBAppend {

	/***
	 * Parent is IJBObject
	 */

	public abstract Parent eif();

	public abstract IJBKeyIf<Parent> elseif(boolean _if);

	public abstract IJBKeyIf<Parent> elseif(Object _if);

	public abstract IJBKeyElse<Parent> else_();
}
