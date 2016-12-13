package com.wjs.jb;
/**
 *
 */

import java.util.Collection;

import com.wjs.jb.abs.IJBObjectIter;
import com.wjs.jb.abs.IJBObjectFor;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBObjectFor<ParentType extends IJBAppend, T> extends IJBBase implements IJBObjectFor<ParentType, T> {

	private final AbsJB jb;
	private final ParentType parent;
	private final Collection<T> collection;
	private final boolean reality;

	JBObjectFor(AbsJB jb, ParentType parent, Collection<T> collection, boolean reality) {
		this.jb = jb;
		this.parent = parent;
		this.reality = reality;
		this.collection = collection;
	}

	@Override
	public JBObjectForIter<ParentType, T> it(IJBObjectIter<T> iter) {
		return new JBObjectForIter<ParentType, T>(jb, parent, collection, iter, reality());
	}

	@Override
	boolean reality() {
		return reality;
	}
}
