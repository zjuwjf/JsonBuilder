package com.wjs.jb.imp;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBKeyElse;

/**
 * @author zju_wjf
 * @date 2016��12��11��
 */
public class JBKeyElse<ParentType extends IJBAppend> extends IJBKeyElse<ParentType> implements JBConstants {
	private final JB jb;
	private final ParentType parent;
	private final String key;
	private final boolean brotherReality;

	JBKeyElse(JB jb, ParentType parent, String key, boolean brotherReality) {
		super();
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.brotherReality = brotherReality;
	}

	@Override
	public JBKeyElsePrepareEnd<ParentType> v(Object value) {
		if(reality()) {
			parent.append(key, value);
		}
		return new JBKeyElsePrepareEnd<ParentType>(jb, parent, key, brotherReality);
	}

	@Override
	public JBObject<JBKeyElsePrepareEnd<ParentType>> o() {
		return o(null);
	}

	@Override
	public JBObject<JBKeyElsePrepareEnd<ParentType>> o(IJBFilter filter) {
		JBKeyElsePrepareEnd<ParentType> end = new JBKeyElsePrepareEnd<ParentType>(jb, parent, key, brotherReality);
		return new JBObject<JBKeyElsePrepareEnd<ParentType>>(jb, end, key, reality(), filter);
	}

	@Override
	public JBArray<JBKeyElsePrepareEnd<ParentType>> a() {
		return a(null);
	}

	@Override
	public JBArray<JBKeyElsePrepareEnd<ParentType>> a(IJBFilter filter) {
		JBKeyElsePrepareEnd<ParentType> end = new JBKeyElsePrepareEnd<ParentType>(jb, parent, key, brotherReality);
		return new JBArray<JBKeyElsePrepareEnd<ParentType>>(jb, end, key, reality(), filter);
	}

	@Override
	void append(String key, Object value) {
		if(reality()) {
			parent.append(key, value);
		}
	}

	@Override
	boolean reality() {
		return parent.reality() && (!brotherReality);
	}
}
