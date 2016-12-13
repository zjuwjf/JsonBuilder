/**
 *
 */
package com.wjs.jb.abs;

import java.util.Collection;

import com.wjs.jb.IJBAppend;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class IJBObjectElse<Parent> extends IJBAppend {

	public abstract IJBKey<? extends IJBObjectElse<Parent>> k(String key) ;

	public abstract IJBObjectElse<Parent> parse(Object bean);

	public abstract IJBObjectIf<? extends IJBObjectElse<Parent>> if_(boolean _if) ;

	public abstract IJBObjectIf<? extends IJBObjectElse<Parent>> if_(Object _if) ;

	public abstract <T> IJBObjectFor<? extends IJBObjectElse<Parent>, T> for_(T[] ts);

	public abstract <T> IJBObjectFor<? extends IJBObjectElse<Parent>, T> for_(Collection<T> ts);

	public abstract Parent eif() ;

}
