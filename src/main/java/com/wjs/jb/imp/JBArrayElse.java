/**
 *
 */
package com.wjs.jb.imp;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.wjs.jb.abs.IJBArrayElse;
import com.wjs.jb.abs.IJBFilter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public class JBArrayElse<ParentType extends IJBAppend> extends IJBArrayElse<ParentType> implements JBConstants {

	private final JB jb;
	private final ParentType parent;
	private final boolean brotherReality;

	JBArrayElse(JB jb, ParentType parent, boolean brotherReality) {
		this.jb = jb;
		this.parent = parent;
		this.brotherReality = brotherReality;
	}

	@Override
	protected boolean reality() {
		return parent.reality() && (!brotherReality);
	}

	@Override
	public JBArrayElse<ParentType> v(Object value) {
		if (reality()) {
			this.append(null, value);
		}

		return this;
	}

	@Override
	public JBObject<JBArrayElse<ParentType>> o() {
		return o(null);
	}

	@Override
	public JBObject<JBArrayElse<ParentType>> o(IJBFilter filter) {
		final JBObject<JBArrayElse<ParentType>> jbValue = new JBObject<JBArrayElse<ParentType>>(jb, this, null, reality(), filter);
		return jbValue;
	}

	@Override
	public JBArray<JBArrayElse<ParentType>> a() {
		return a(null);
	}

	@Override
	public JBArray<JBArrayElse<ParentType>> a(IJBFilter filter) {
		final JBArray<JBArrayElse<ParentType>> jbValue = new JBArray<JBArrayElse<ParentType>>(jb, this, null, reality(), filter);
		return jbValue;
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
	public <T> JBArrayFor<JBArrayElse<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBArrayFor<JBArrayElse<ParentType>, T> for_(Collection<T> ts) {
		return new JBArrayFor<JBArrayElse<ParentType>, T>(jb, this, ts, reality());
	}

	@Override
	public JBArrayIf<JBArrayElse<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBArrayIf<JBArrayElse<ParentType>> if_(boolean _if) {
		return new JBArrayIf<JBArrayElse<ParentType>>(jb, this, false, _if);
	}

	@Override
	public JBArrayElse<ParentType> parse(Object... objects) {
		if(objects != null) {
			for(Object value : objects) {
				this.v(value);
			}
		}
		return this;
	}
}
