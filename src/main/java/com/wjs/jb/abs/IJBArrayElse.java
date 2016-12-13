/**
 *
 */
package com.wjs.jb.abs;

import java.util.Collection;

import com.wjs.jb.imp.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBArrayElse<Parent> extends IJBAppend {

	public abstract IJBArrayElse<Parent> v(Object value);

	public abstract IJBObject<? extends IJBArrayElse<Parent>> o();

	public abstract IJBObject<? extends IJBArrayElse<Parent>> o(IJBFilter filter);

	public abstract IJBArray<? extends IJBArrayElse<Parent>> a();

	public abstract IJBArray<? extends IJBArrayElse<Parent>> a(IJBFilter filter);

	public abstract Parent eif();

	public abstract IJBArrayIf<? extends IJBArrayElse<Parent>> if_(boolean _if);

	public abstract IJBArrayIf<? extends IJBArrayElse<Parent>> if_(Object _if);

	public abstract <T> IJBArrayFor<? extends IJBArrayElse<Parent>, T> for_(T[] ts);

	public abstract <T> IJBArrayFor<? extends IJBArrayElse<Parent>, T> for_(Collection<T> ts);

	public abstract IJBArrayElse<Parent> parse(Object... objects);
}
