/**
 *
 */
package com.wjs.jb;

import com.wjs.jb.abs.IJBKeyIfPrepareEnd;

/**
 * @author zju_wjf
 * @date 2016年12月13日
 */
public class JBKeyIfPrepareEnd<ParentType extends IJBAppend> extends IJBKeyIfPrepareEnd<ParentType> implements JBConstants {

	private final JB jb;
	private final ParentType parent;
	private final String key;
	private final boolean brotherReality;

	JBKeyIfPrepareEnd(JB jb, ParentType parent, String key, boolean brotherReality) {
		super();
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.brotherReality = brotherReality;
	}

	@Override
	public ParentType eif() {
		return parent;
	}

	@Override
	public JBKeyIf<ParentType> elseif(Object _if) {
		final boolean b = JBUtils.b(_if);
		return elseif(b);
	}

	@Override
	public JBKeyIf<ParentType> elseif(boolean _if) {
		return new JBKeyIf<ParentType>(jb, parent, key, brotherReality, _if);
	}

	@Override
	public JBKeyElse<ParentType> else_() {
		return new JBKeyElse<ParentType>(jb, parent, key, brotherReality);
	}

	@Override
	void append(String key, Object value) {
		if (reality()) {
			parent.append(key, value);
		}
	}

	@Override
	boolean reality() {
		return parent.reality() && (!brotherReality);
	}
}
