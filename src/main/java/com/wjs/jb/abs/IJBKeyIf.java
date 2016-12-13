/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBKeyIf<Parent extends IJBAppend> extends IJBAppend {

	/***
	 * Parent is IJBObject
	 */
	public abstract IJBKeyIfPrepareEnd<Parent> v(Object value);

	public abstract IJBObject<? extends IJBKeyIfPrepareEnd<Parent>> o();

	public abstract IJBObject<? extends IJBKeyIfPrepareEnd<Parent>> o(IJBFilter filter);

	public abstract IJBArray<? extends IJBKeyIfPrepareEnd<Parent>> a();

	public abstract IJBArray<? extends IJBKeyIfPrepareEnd<Parent>> a(IJBFilter filter);

	public abstract IJBKeyIf<? extends IJBKeyIfPrepareEnd<Parent>> if_(boolean _if);

	public abstract IJBKeyIf<? extends IJBKeyIfPrepareEnd<Parent>> if_(Object _if);
}
