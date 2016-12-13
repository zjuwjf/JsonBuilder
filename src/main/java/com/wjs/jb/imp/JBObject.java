/**
 *
 */
package com.wjs.jb.imp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBObject;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBObject<ParentType extends IJBAppend> extends IJBObject<ParentType> implements JBConstants {
	private final JB jb;
	private final ParentType parent;
	private final IJBFilter filter;
	private final String key;
	private final boolean reality;
	private Object target;

	JBObject(JB jb, ParentType parent, String key, boolean reality, IJBFilter filter) {
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.reality = reality;
		this.filter = filter;
	}


	@Override
	public JBKey<JBObject<ParentType>> k(String key) {
		return new JBKey<JBObject<ParentType>>(jb, this, key, reality);
	}

	@Override
	public ParentType eo() {
		if (reality()) {
			parent.append(key, target == null ? jb.jsonAdapter().empyObject() : target);
		}

		return parent;
	}

	private final Object safeTarget() {
		if (target == null) {
			target = jb.jsonAdapter().object();
		}
		return target;
	}

	@Override
	void append(String key, Object value) {
		if (reality()) {
			JBEntry jbEntry = JBUtils.safeFilter(key, value, jb.filters());
			if (jbEntry != null) {
				jbEntry = JBUtils.safeFilter(key, value, filter);
			}
			if (jbEntry != null) {
				jb.jsonAdapter().appendObject(safeTarget(), key, value);
			}
		}
	}

	@Override
	public JBObjectIf<JBObject<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBObjectIf<JBObject<ParentType>> if_(boolean _if) {
		return new JBObjectIf<JBObject<ParentType>>(jb, this, false,  _if);
	}

	@Override
	public <T> JBObjectFor<JBObject<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBObjectFor<JBObject<ParentType>, T> for_(Collection<T> ts) {
		return new JBObjectFor<JBObject<ParentType>, T>(jb, this, ts, reality);
	}

	@Override
	boolean reality() {
		return reality;
	}

	@Override
	public JBObject<ParentType> parse(Object bean) {
		//bean -> collection
		if(reality() && bean != null) {
			final Collection< ? extends Entry<String, ? extends Object> > collection = jb.jsonAdapter().split(bean);
			if(collection != null) {
				for(Entry<String, ? extends Object> entry : collection) {
					append(entry.getKey(), entry.getValue());
				}
			}
		}
		return this;
	}

}
