/**
 *
 */
package com.wjs.jb.imp;

import java.util.Arrays;
import java.util.Collection;

import com.wjs.jb.abs.IJBFilter;

/**
 * @author zju_wjf
 * @date 2016��12��10��
 */
public final class JBUtils {

	//---------------- -------------------

	//---------------- -------------------
	static <T> T[] arrayCat(T[] a, T[] b) {
		if (a == null || a.length == 0) {
			return b;
		} else if (b == null || b.length == 0) {
			return a;
		}
		T[] c = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	static JBEntry safeFilter(String key, Object value, IJBFilter... filters) {
		final JBEntry entry = new JBEntry(key, value);
		try {
			if (filters != null) {
				for (IJBFilter filter : filters) {
					if (filter != null && !filter.filter(entry)) {
						return null;
					}
				}
			}
			return entry;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	static boolean b(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof Boolean) {
			return (Boolean) obj;
		}

		if (obj instanceof String) {
			return ((String) obj).length() > 0;
		}

		if (obj instanceof Collection) {
			return ((Collection<?>) obj).size() > 0;
		}

		if (obj.getClass().isArray()) {
			int i = ((Object[]) obj).length;
			return i > 0;
		}

		return true;
	}

	static void p() {

	}

	// public static void main(String [] args) {
	// String [][] s = new String[][]{ {""}, {""}};
	// System.err.println(tb(s));
	// }
}
