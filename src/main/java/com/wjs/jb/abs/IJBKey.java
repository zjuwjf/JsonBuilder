/**
 *
 */
package com.wjs.jb.abs;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public interface IJBKey<Parent>  {

	Parent v(Object value);

	IJBObject<Parent> o();

	IJBObject<Parent> o(IJBFilter filter);

	IJBArray<Parent> a();

	IJBArray<Parent> a(IJBFilter filter);

//	IJBObjectIf<? extends IJBKey<Parent>> if_(boolean _if) ;
//
//	IJBObjectIf<? extends IJBKey<Parent>> if_(Object _if) ;
//
//
}
