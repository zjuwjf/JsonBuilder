/**
 *
 */
package com.wjs.jb;

import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBIter;

/**
 * @author zju_wjf
 * @date 2016Äê12ÔÂ10ÈÕ
 */
public interface JBConstants {

	@SuppressWarnings("rawtypes")
	public static final IJBIter DEFAULT_OBJECT_ITER = new IJBIter<Object>() {
		@Override
		public JBEntry iter(int index, Object t) {
			return new JBEntry(String.valueOf(index), t);
		}
	};

	@SuppressWarnings("rawtypes")
	public static final IJBIter DEFAULT_ARRAY_ITER = new IJBIter<Object>() {
		@Override
		public JBEntry iter(int index, Object t) {
			//unused index
			return new JBEntry(null, t);
		}
	};

	public static final IJBFilter DEFAULT_FILTER = new IJBFilter() {
		public boolean filter(JBEntry entry) {
			return entry != null && JBUtils.b(entry.getValue());
		}
	};

}
