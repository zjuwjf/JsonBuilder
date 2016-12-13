/**
 *
 */
package com.wjs.jb.abs;

import java.util.Collection;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public abstract class IJBArrayIf<Parent> extends IJBAppend {

	public abstract IJBArrayIf<Parent> v(Object value);

	public abstract IJBObject<? extends IJBArrayIf<Parent>> o();

	public abstract IJBObject<? extends IJBArrayIf<Parent>> o(IJBFilter filter);

	public abstract IJBArray<? extends IJBArrayIf<Parent>> a();

	public abstract IJBArray<? extends IJBArrayIf<Parent>> a(IJBFilter filter);

	public abstract Parent eif() ;

	public abstract IJBArrayIf<? extends IJBArrayIf<Parent>> if_(boolean _if) ;

	public abstract IJBArrayIf<? extends IJBArrayIf<Parent>> if_(Object _if) ;

	public abstract IJBArrayIf<Parent> elseif(boolean _if);

	public abstract IJBArrayIf<Parent> elseif(Object _if);

	public abstract IJBArrayIf<Parent> else_();

	public abstract <T> IJBArrayFor<? extends IJBArrayIf<Parent>, T> for_(T[] ts);

	public abstract <T> IJBArrayFor<? extends IJBArrayIf<Parent>, T> for_(Collection<T> ts);

	public abstract IJBArrayIf<Parent> parse(Object...objects);
}
