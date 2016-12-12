/**
 *
 */
package com.wjs.jb;

import java.util.Collection;

import com.wjs.jb.abs.IJBArrayForIter;
import com.wjs.jb.abs.IJBIter;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public class JBArrayForIter<GrandParentType extends IJBAppend, T>  extends IJBBase implements IJBArrayForIter<GrandParentType>{

	private final GrandParentType grandParent;
	private final Collection<T> collection;
	private final IJBIter<T> iter;
	private final boolean reality;

	JBArrayForIter(AbsJB jb, GrandParentType grandParent, Collection<T> collection, IJBIter<T> iter, boolean reality) {
		this.grandParent = grandParent;
		this.collection = collection;
		this.iter = iter;
		this.reality = reality;
	}

	@Override
	public GrandParentType efor() {
		if(reality()) {
			if(collection != null && iter != null) {
				int i = 0;
				for(T t : collection) {
					final JBEntry entry = iter.iter(i++, t);
					if(entry != null) {
						grandParent.append(entry.getKey(), entry.getValue());
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
