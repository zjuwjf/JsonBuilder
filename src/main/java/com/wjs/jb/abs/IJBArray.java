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
public abstract class IJBArray<Parent> extends IJBAppend {

	public abstract IJBArray<Parent> v(Object value);

	public abstract IJBObject<? extends IJBArray<Parent>> o();

	public abstract IJBObject<? extends IJBArray<Parent>> o(IJBFilter filter);

	public abstract IJBArray<? extends IJBArray<Parent>> a();

	public abstract IJBArray<? extends IJBArray<Parent>> a(IJBFilter filter);

	public abstract IJBArrayIf<? extends IJBArray<Parent>> if_(boolean _if);

	public abstract IJBArrayIf<? extends IJBArray<Parent>> if_(Object _if);

	public abstract <T> IJBArrayFor<? extends IJBArray<Parent>, T> for_(T[] ts);

	public abstract <T> IJBArrayFor<? extends IJBArray<Parent>, T> for_(Collection<T> ts);

	public abstract Parent ea();

	public abstract IJBArray<Parent> parse(Object...objects);
}
