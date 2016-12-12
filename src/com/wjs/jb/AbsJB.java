package com.wjs.jb;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public abstract class AbsJB extends IJBAppend {

	private IJBFilter[] globalFilters;
	private Object root;

	public AbsJB() {

	}

	abstract IJBJsonAdapter jsonAdapter();

	IJBFilter[] filters() {
		return globalFilters;
	}

	public AbsJB addFilters(IJBFilter... filters) {
		globalFilters = JBUtils.arrayCat(globalFilters, filters);
		return this;
	}

	public AbsJB v(Object value) {
		append(null, jsonAdapter().transformV(value));
		return this;
	}

	public JBObject<AbsJB> o() {
		return o(null);
	}

	public JBArray<AbsJB> a() {
		return a(null);
	}

	public JBObject<AbsJB> o(final IJBFilter filter) {
		return new JBObject<AbsJB>(this, this, null, true, filter);
	}

	public JBArray<AbsJB> a(final IJBFilter filter) {
		return new JBArray<AbsJB>(this, this, null, true, filter);
	}

	public Object json() {
		return root;
	}

	void append(String key, Object value) {
		root = value;
	}

	@Override
	boolean reality() {
		// unused
		return false;
	}
}
