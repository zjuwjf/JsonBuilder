/**
 *
 */
package com.wjs.jb;

import com.wjs.jb.abs.IJBArrayIter;
import com.wjs.jb.abs.IJBFilter;
import com.wjs.jb.abs.IJBObjectIter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public interface JBConstants {

	@SuppressWarnings("rawtypes")
	public static final IJBObjectIter DEFAULT_OBJECT_ITER = new IJBObjectIter<Object>() {
		@Override
		public JBEntry iter(int index, Object t) {
			return new JBEntry(String.valueOf(index), t);
		}
	};

	@SuppressWarnings("rawtypes")
	public static final IJBArrayIter DEFAULT_ARRAY_ITER = new IJBArrayIter<Object>() {
		@Override
		public Object iter(Object t) {
			//unused index
			return t;
		}
	};

	public static final IJBFilter DEFAULT_FILTER = new IJBFilter() {
		public boolean filter(JBEntry entry) {
			return entry != null && JBUtils.b(entry.getValue());
		}
	};

}
