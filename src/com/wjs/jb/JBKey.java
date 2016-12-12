/**
 *
 */
package com.wjs.jb;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBKey;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public class JBKey<ParentType extends IJBAppend> extends IJBAppend implements IJBKey<ParentType>, JBConstants{
	private final AbsJB jb;
	private final ParentType parent;
	private final String key;
	private final boolean reality;

	JBKey(AbsJB jb, ParentType parent, String key, boolean reality) {
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.reality = reality;
	}

	@Override
	public ParentType v(Object value) {
		if(reality() && parent != null){
			parent.append(key, value);
		}
		return parent;
	}

	@Override
	public JBObject<ParentType> o() {
		return o(null);
	}

	@Override
	public JBArray<ParentType> a() {
		return a(null);
	}

	@Override
	public JBObject<ParentType> o(IJBFilter filter) {
		return new JBObject<ParentType>(jb, this.parent, key, reality(), filter);
	}

	@Override
	public JBArray<ParentType> a(IJBFilter filter) {
		return new JBArray<ParentType>(jb, this.parent, key, reality(), filter);
	}

	@Override
	boolean reality() {
		return reality;
	}

//	@Override
//	public JBObjectIf<JBKey<ParentType>> if_(boolean _if) {
//		return new JBObjectIf<JBKey<ParentType>>(jb, this, reality(), false, _if);
//	}
//
//	@Override
//	public JBObjectIf<JBKey<ParentType>> if_(Object _if) {
//		final boolean b = JBUtils.b(_if);
//		return if_(b);
//	}

	@Override
	void append(String key, Object value) {
		if(reality() && parent != null) {
			parent.append(key, value);
		}
	}
}
