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
public abstract class IJBObjectIf<Parent> extends IJBAppend {

	public abstract IJBKey<? extends IJBObjectIf<Parent>> k(String key) ;

	public abstract IJBObjectIf<? extends IJBObjectIf<Parent>> if_(boolean _if) ;

	public abstract IJBObjectIf<? extends IJBObjectIf<Parent>> if_(Object _if) ;

	public abstract IJBObjectIf<Parent> elseif(boolean _if);

	public abstract IJBObjectIf<Parent> elseif(Object _if);

	public abstract IJBObjectElse<Parent> else_();

	public abstract <T> IJBObjectFor<? extends IJBObjectIf<Parent>, T> for_(T[] ts);

	public abstract <T> IJBObjectFor<? extends IJBObjectIf<Parent>, T> for_(Collection<T> ts);

	public abstract Parent eif() ;

	public abstract IJBObjectIf<Parent> parse(Object bean);

}
