/**
 *
 */
package com.wjs.jb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.wjs.jb.abs.IJBArrayIf;
import com.wjs.jb.abs.IJBFilter;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public class JBArrayIf<ParentType extends IJBAppend> extends IJBArrayIf<ParentType> implements JBConstants {

	private final AbsJB jb;
	private final ParentType parent;
	private final boolean parentReality;
	private final boolean brotherReality;
	private final boolean selfReality;

	JBArrayIf(AbsJB jb, ParentType parent, boolean parentReality, boolean brotherReality, boolean selfReality) {
		this.jb = jb;
		this.parent = parent;
		this.parentReality = parentReality;
		this.brotherReality = brotherReality;
		this.selfReality = selfReality;
	}

	@Override
	protected boolean reality() {
		return parentReality && (!brotherReality) && selfReality;
	}

	@Override
	public JBArrayIf<ParentType> v(Object value) {
		if (reality()) {
			this.append(null, value);
		}

		return this;
	}

	@Override
	public JBObject<JBArrayIf<ParentType>> o() {
		return o(null);
	}

	@Override
	public JBObject<JBArrayIf<ParentType>> o(IJBFilter filter) {
		final JBObject<JBArrayIf<ParentType>> jbValue = new JBObject<JBArrayIf<ParentType>>(jb, this, null, reality(), filter);
		return jbValue;
	}

	@Override
	public JBArray<JBArrayIf<ParentType>> a() {
		return a(null);
	}

	@Override
	public JBArray<JBArrayIf<ParentType>> a(IJBFilter filter) {
		final JBArray<JBArrayIf<ParentType>> jbValue = new JBArray<JBArrayIf<ParentType>>(jb, this, null, reality(), filter);
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
	public <T> JBArrayFor<JBArrayIf<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBArrayFor<JBArrayIf<ParentType>, T> for_(Collection<T> ts) {
		return new JBArrayFor<JBArrayIf<ParentType>, T>(jb, this, ts, reality());
	}

	@Override
	public JBArrayIf<JBArrayIf<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBArrayIf<JBArrayIf<ParentType>> if_(boolean _if) {
		return new JBArrayIf<JBArrayIf<ParentType>>(jb, this, reality(), false, _if);
	}

	@Override
	public JBArrayIf<ParentType> elseif(boolean _if) {
		return new JBArrayIf<ParentType>(jb, parent, parent.reality(), (brotherReality || selfReality),  _if);
	}

	@Override
	public IJBArrayIf<ParentType> elseif(Object _if) {
		final boolean b = JBUtils.b(_if);
		return elseif(b);
	}

	@Override
	public IJBArrayIf<ParentType> else_() {
		return elseif(true);
	}

	@Override
	public JBArrayIf<ParentType> parse(Object... objects) {
		if(objects != null) {
			for(Object value : objects) {
				this.v(value);
			}
		}
		return this;
	}
}
