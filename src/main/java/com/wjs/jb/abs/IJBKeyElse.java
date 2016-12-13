/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.imp.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBKeyElse<Parent extends IJBAppend> extends IJBAppend {

	/***
	 * Parent is IJBObject
	 */
	public abstract IJBKeyElsePrepareEnd<Parent> v(Object value);

	public abstract IJBObject<? extends IJBKeyElsePrepareEnd<Parent>> o();

	public abstract IJBObject<? extends IJBKeyElsePrepareEnd<Parent>> o(IJBFilter filter);

	public abstract IJBArray<? extends IJBKeyElsePrepareEnd<Parent>> a();

	public abstract IJBArray<? extends IJBKeyElsePrepareEnd<Parent>> a(IJBFilter filter);

}
