/**
 *
 */
package com.wjs.jb.abs;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface IJBKeyIf<Parent>  {

	IJBKeyIf<Parent> v(Object value);

	IJBObject<? extends IJBKeyIf<Parent>> o();

	IJBObject<? extends IJBKeyIf<Parent>> o(IJBFilter filter);

	IJBArray<? extends IJBKeyIf<Parent>> a();

	IJBArray<? extends IJBKeyIf<Parent>> a(IJBFilter filter);

	IJBKeyIf<? extends IJBKeyIf<Parent>> if_(boolean _if) ;

	IJBKeyIf<? extends IJBKeyIf<Parent>> if_(Object _if) ;

	void eif();
}
