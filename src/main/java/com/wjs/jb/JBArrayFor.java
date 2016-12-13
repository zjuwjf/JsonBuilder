package com.wjs.jb;
/**
 *
 */

import java.util.Collection;

import com.wjs.jb.abs.IJBArrayFor;
import com.wjs.jb.abs.IJBArrayIter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBArrayFor<ParentType extends IJBAppend, T>  extends IJBBase implements IJBArrayFor<ParentType, T>, JBConstants {

	private final AbsJB jb;
	private final ParentType parent;
	private final Collection<T> array;
	private final boolean reality;

	JBArrayFor(AbsJB jb, ParentType parent, Collection<T> collection, boolean reality) {
		this.jb = jb;
		this.parent = parent;
		this.reality = reality;
		this.array = collection;
	}

	@Override
	public JBArrayForIter<ParentType, T> it(IJBArrayIter<T> iter) {
		return new JBArrayForIter<ParentType, T>(jb, parent, array, iter, reality());
	}

	@SuppressWarnings("unchecked")
	@Override
	public JBArrayForIter<ParentType, T> it() {
		return it(DEFAULT_ARRAY_ITER);
	}

	@Override
	boolean reality() {
		return reality;
	}
}
