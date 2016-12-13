/**
 *
 */
package com.wjs.jb.imp;

import com.wjs.jb.abs.IJBKeyElsePrepareEnd;

/**
 * @author zju_wjf
 * @date 2016年12月13日
 */
public class JBKeyElsePrepareEnd<ParentType extends IJBAppend> extends IJBKeyElsePrepareEnd<ParentType> implements JBConstants {

	private final ParentType parent;
	private final boolean brotherReality;

	JBKeyElsePrepareEnd(JB jb, ParentType parent, String key, boolean brotherReality) {
		super();
		this.parent = parent;
		this.brotherReality = brotherReality;
	}

	@Override
	public ParentType eif() {
		return parent;
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
