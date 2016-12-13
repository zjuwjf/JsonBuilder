/**
 *
 */
package com.wjs.jb.imp;

import java.util.Collection;

import com.wjs.jb.abs.IJBObjectIter;
import com.wjs.jb.abs.IJBObjectForIter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBObjectForIter<GrandParentType extends IJBAppend, T> extends IJBBase implements IJBObjectForIter<GrandParentType>{

	private final GrandParentType grandParent;
	private final Collection<T> collection;
	private final IJBObjectIter<T> iter;
	private final boolean reality;

	JBObjectForIter(JB jb, GrandParentType grandParent, Collection<T> collection, IJBObjectIter<T> iter, boolean reality) {
		this.grandParent = grandParent;
		this.collection = collection;
		this.iter = iter;
		this.reality = reality;
	}

	@Override
	public GrandParentType efor() {
		if(reality()) {
			if(collection != null && iter != null) {
				int i= 0 ;
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
