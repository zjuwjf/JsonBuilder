/**
 *
 */
package com.wjs.jb;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBKey;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBKey<ParentType extends IJBAppend> extends IJBKey<ParentType> implements JBConstants{
	private final JB jb;
	private final ParentType parent;
	private final String key;
	private final boolean reality;

	JBKey(JB jb, ParentType parent, String key, boolean reality) {
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.reality = reality;
	}

	@Override
	public ParentType v(Object value) {
		if(reality()){
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

	@Override
	void append(String key, Object value) {
		if(reality()) {
			parent.append(key, value);
		}
	}

	@Override
	public JBKeyIf<ParentType> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBKeyIf<ParentType> if_(boolean _if) {
		return new JBKeyIf<ParentType>(jb, parent, key, false, _if);
	}
}
