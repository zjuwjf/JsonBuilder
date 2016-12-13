/**
 *
 */
package com.wjs.jb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.wjs.jb.abs.IJBObjectElse;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBObjectElse<ParentType extends IJBAppend> extends IJBObjectElse<ParentType> {

	private final JB jb;
	private final ParentType parent;
	private final boolean brotherReality;

	JBObjectElse(JB jb, ParentType parent, boolean brotherReality) {
		this.jb = jb;
		this.parent = parent;
		this.brotherReality = brotherReality;
	}

	@Override
	public JBKey<JBObjectElse<ParentType>> k(String key) {
		return new JBKey<JBObjectElse<ParentType>>(jb, this, key, reality());
	}

	@Override
	void append(String key, Object value) {
		if (reality()) {
			this.parent.append(key, value);
		}
	}

	@Override
	public ParentType eif() {
		// do nothing, already did in children scope
		return parent;
	}

	@Override
	public JBObjectIf<JBObjectElse<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBObjectIf<JBObjectElse<ParentType>> if_(boolean _if) {
		return new JBObjectIf<JBObjectElse<ParentType>>(jb, this, false, _if);
	}

	@Override
	public <T> JBObjectFor<JBObjectElse<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBObjectFor<JBObjectElse<ParentType>, T> for_(Collection<T> ts) {
		return new JBObjectFor<JBObjectElse<ParentType>, T>(jb, this, ts, reality());
	}

	@Override
	boolean reality() {
		return parent.reality() && (!brotherReality);
	}

	@Override
	public JBObjectElse<ParentType> parse(Object bean) {
		if (reality() && bean != null) {
			final Collection<? extends Entry<String, ? extends Object>> collection = jb.jsonAdapter().split(bean);
			if (collection != null) {
				for (Entry<String, ? extends Object> entry : collection) {
					append(entry.getKey(), entry.getValue());
				}
			}
		}
		return this;
	}
}
