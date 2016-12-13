package com.wjs.jb;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public abstract class JB extends IJBAppend {

	private IJBFilter[] globalFilters;
	private Object root;

	public JB() {

	}

	abstract IJBJsonAdapter jsonAdapter();

	IJBFilter[] filters() {
		return globalFilters;
	}

	public JB addFilters(IJBFilter... filters) {
		globalFilters = JBUtils.arrayCat(globalFilters, filters);
		return this;
	}

	public JB v(Object value) {
		append(null, jsonAdapter().transformV(value));
		return this;
	}

	public JBObject<JB> o() {
		return o(null);
	}

	public JBArray<JB> a() {
		return a(null);
	}

	public JBObject<JB> o(final IJBFilter filter) {
		return new JBObject<JB>(this, this, null, true, filter);
	}

	public JBArray<JB> a(final IJBFilter filter) {
		return new JBArray<JB>(this, this, null, true, filter);
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
