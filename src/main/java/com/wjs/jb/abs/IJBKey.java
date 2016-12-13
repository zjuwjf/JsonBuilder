/**
 *
 */
package com.wjs.jb.abs;

import com.wjs.jb.imp.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBKey<Parent extends IJBAppend> extends IJBAppend{

	public abstract Parent v(Object value);

	public abstract IJBObject<Parent> o();

	public abstract IJBObject<Parent> o(IJBFilter filter);

	public abstract IJBArray<Parent> a();

	public abstract IJBArray<Parent> a(IJBFilter filter);

	public abstract IJBKeyIf<Parent> if_(boolean _if) ;

	public abstract IJBKeyIf<Parent> if_(Object _if) ;
}
