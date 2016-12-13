package com.wjs.jb.imp;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBKeyIf;

/**
 * @author zju_wjf
 * @date 2016��12��11��
 */
public class JBKeyIf<ParentType extends IJBAppend> extends IJBKeyIf<ParentType> implements JBConstants {
	private final JB jb;
	private final ParentType parent;
	private final String key;
	private final boolean brotherReality;
	private final boolean selfReality;

	JBKeyIf(JB jb, ParentType parent, String key, boolean brotherReality, boolean selfReality) {
		super();
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.brotherReality = brotherReality;
		this.selfReality = selfReality;
	}

	@Override
	public JBKeyIfPrepareEnd<ParentType> v(Object value) {
		if(reality()) {
			parent.append(key, value);
		}
		return new JBKeyIfPrepareEnd<ParentType>(jb, parent, key, brotherReality || selfReality);
	}

	@Override
	public JBObject<JBKeyIfPrepareEnd<ParentType>> o() {
		return o(null);
	}

	@Override
	public JBObject<JBKeyIfPrepareEnd<ParentType>> o(IJBFilter filter) {
		JBKeyIfPrepareEnd<ParentType> end = new JBKeyIfPrepareEnd<ParentType>(jb, parent, key, brotherReality || selfReality);
		return new JBObject<JBKeyIfPrepareEnd<ParentType>>(jb, end, key, reality(), filter);
	}

	@Override
	public JBArray<JBKeyIfPrepareEnd<ParentType>> a() {
		return a(null);
	}

	@Override
	public JBArray<JBKeyIfPrepareEnd<ParentType>> a(IJBFilter filter) {
		JBKeyIfPrepareEnd<ParentType> end = new JBKeyIfPrepareEnd<ParentType>(jb, parent, key, brotherReality || selfReality);
		return new JBArray<JBKeyIfPrepareEnd<ParentType>>(jb, end, key, reality(), filter);
	}

	@Override
	void append(String key, Object value) {
		if(reality()) {
			parent.append(key, value);
		}
	}

	@Override
	boolean reality() {
		return parent.reality() && (!brotherReality) && selfReality;
	}

	@Override
	public JBKeyIf<JBKeyIfPrepareEnd<ParentType>> if_(boolean _if) {
		JBKeyIfPrepareEnd<ParentType> end = new JBKeyIfPrepareEnd<ParentType>(jb, parent, key, brotherReality || selfReality);
		return new JBKeyIf<JBKeyIfPrepareEnd<ParentType>>(jb, end, key, false, _if);
	}

	@Override
	public IJBKeyIf<JBKeyIfPrepareEnd<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}
}
