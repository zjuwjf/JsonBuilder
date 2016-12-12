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
public abstract class IJBObject<Parent> extends IJBAppend {

	public abstract IJBKey<? extends IJBObject<Parent>> k(String key) ;

	public abstract IJBObjectIf<? extends IJBObject<Parent>> if_(boolean _if) ;

	public abstract IJBObjectIf<? extends IJBObject<Parent>> if_(Object _if) ;

	public abstract Parent eo() ;

	public abstract <T> IJBObjectFor<? extends IJBObject<Parent>, T> for_(T[] ts);

	public abstract <T> IJBObjectFor<? extends IJBObject<Parent>, T> for_(Collection<T> ts);

	public abstract IJBObject<Parent> parse(Object bean);
}
