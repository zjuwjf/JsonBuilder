/**
 *
 */
package com.wjs.jb;

import java.util.Collection;

import com.wjs.jb.abs.IJBArrayForIter;
import com.wjs.jb.abs.IJBArrayIter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBArrayForIter<GrandParentType extends IJBAppend, T>  extends IJBBase implements IJBArrayForIter<GrandParentType>{

	private final GrandParentType grandParent;
	private final Collection<T> collection;
	private final IJBArrayIter<T> iter;
	private final boolean reality;

	JBArrayForIter(JB jb, GrandParentType grandParent, Collection<T> collection, IJBArrayIter<T> iter, boolean reality) {
		this.grandParent = grandParent;
		this.collection = collection;
		this.iter = iter;
		this.reality = reality;
	}

	@Override
	public GrandParentType efor() {
		if(reality()) {
			if(collection != null && iter != null) {
				for(T t : collection) {
					final Object entry = iter.iter(t);
					if(entry != null) {
						grandParent.append(null, entry);
					}
				}
			}
		}

		return grandParent;
	}

	@Override
	boolean reality() {
		return reality;
	}
}
