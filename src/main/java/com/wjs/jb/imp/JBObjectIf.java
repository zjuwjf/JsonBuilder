/**
 *
 */
package com.wjs.jb.imp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.wjs.jb.abs.IJBObjectIf;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBObjectIf<ParentType extends IJBAppend> extends IJBObjectIf<ParentType> {

	private final JB jb;
	private final ParentType parent;
	private final boolean brotherReality;
	private final boolean selfReality;

	JBObjectIf(JB jb, ParentType parent, boolean brotherReality, boolean selfReality) {
		this.jb = jb;
		this.parent = parent;
		this.brotherReality = brotherReality;
		this.selfReality = selfReality;
	}

	@Override
	public JBKey<JBObjectIf<ParentType>> k(String key) {
		return new JBKey<JBObjectIf<ParentType>>(jb, this, key, reality());
	}

	@Override
	void append(String key, Object value) {
		if (reality()) {
			 this.parent.append(key, value);
		}
	}

	@Override
	public ParentType eif() {
		//do nothing, already did in children scope
		return parent;
	}

	@Override
	public JBObjectIf<JBObjectIf<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBObjectIf<JBObjectIf<ParentType>> if_(boolean _if) {
		return new JBObjectIf<JBObjectIf<ParentType>>(jb, this, false, _if);
	}

	@Override
	public <T> JBObjectFor<JBObjectIf<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBObjectFor<JBObjectIf<ParentType>, T> for_(Collection<T> ts) {
		return new JBObjectFor<JBObjectIf<ParentType>, T>(jb, this, ts, reality());
	}

	@Override
	boolean reality() {
		return parent.reality() && (!brotherReality) && selfReality;
	}

	@Override
	public JBObjectIf<ParentType> elseif(boolean _if) {
		return new JBObjectIf<ParentType>(jb, parent, (brotherReality || selfReality), _if);
	}

	@Override
	public JBObjectIf<ParentType> elseif(Object _if) {
		final boolean b = JBUtils.b(_if);
		return elseif(b);
	}

	@Override
	public JBObjectElse<ParentType> else_() {
		return new JBObjectElse<ParentType>(jb, parent, (brotherReality || selfReality));
	}

	@Override
	public JBObjectIf<ParentType> parse(Object bean) {
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
