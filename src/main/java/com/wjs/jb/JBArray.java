/**
 *
 */
package com.wjs.jb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.wjs.jb.abs.IJBArray;
import com.wjs.jb.abs.IJBFilter;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public class JBArray<ParentType extends IJBAppend> extends IJBArray<ParentType> implements JBConstants {

	private final AbsJB jb;
	private final ParentType parent;
	private final String key;
	private final boolean reality;
	private final IJBFilter filter;
	private Object target;

	JBArray(AbsJB jb, ParentType parent, String key, boolean reality, IJBFilter filter) {
		this.jb = jb;
		this.parent = parent;
		this.key = key;
		this.reality = reality;
		this.filter = filter;
	}

	@Override
	public JBArray<ParentType> v(Object value) {
		if (reality()) {
			this.append(null, value);
		}
		return this;
	}

	@Override
	public JBObject<JBArray<ParentType>> o() {
		return o(null);
	}

	@Override
	public JBObject<JBArray<ParentType>> o(IJBFilter filter) {
		return new JBObject<JBArray<ParentType>>(jb, this, null, reality(), filter);
	}

	@Override
	public JBArray<JBArray<ParentType>> a() {
		return a(null);
	}

	@Override
	public JBArray<JBArray<ParentType>> a(IJBFilter filter) {
		return new JBArray<JBArray<ParentType>>(jb, this, null, reality(), filter);
	}

	@Override
	public ParentType ea() {
		if (reality() && parent != null) {
			parent.append(key, target == null ? jb.jsonAdapter().empyArray() : target);
		}

		return parent;
	}

	@Override
	void append(String key, Object value) {
		if (reality()) {
			JBEntry jbEntry = JBUtils.safeFilter(null, value, jb.filters());

			if (jbEntry != null) {
				jbEntry = JBUtils.safeFilter(jbEntry.getKey(), jbEntry.getValue(), filter);
			}

			if (jbEntry != null) {
				jb.jsonAdapter().appendArray(safeTarget(), key, value);
			}
		}
	}

	private final Object safeTarget() {
		if (target == null) {
			target = jb.jsonAdapter().array();
		}
		return target;
	}

	@Override
	public JBArrayIf<JBArray<ParentType>> if_(Object _if) {
		final boolean b = JBUtils.b(_if);
		return if_(b);
	}

	@Override
	public JBArrayIf<JBArray<ParentType>> if_(boolean _if) {
		return new JBArrayIf<JBArray<ParentType>>(jb, this, reality(), false, _if);
	}

	@Override
	public <T> JBArrayFor<JBArray<ParentType>, T> for_(T[] ts) {
		List<T> list = ts != null ? Arrays.asList(ts) : null;
		return for_(list);
	}

	@Override
	public <T> JBArrayFor<JBArray<ParentType>, T> for_(Collection<T> ts) {
		return new JBArrayFor<JBArray<ParentType>, T>(jb, this, ts, reality());
	}

	@Override
	boolean reality() {
		return reality;
	}

	@Override
	public JBArray<ParentType> parse(Object... objects) {
		if(objects != null) {
			for(Object value : objects) {
				this.v(value);
			}
		}
		return this;
	}
}
