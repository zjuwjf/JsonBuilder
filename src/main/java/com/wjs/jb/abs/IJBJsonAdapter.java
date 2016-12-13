/**
 *
 */
package com.wjs.jb.abs;

import java.util.Collection;
import java.util.Map.Entry;

/**
 * @author zju_wjf
 * @date 2016��12��11��
 */
public interface IJBJsonAdapter {
	/**
	 * generate a json_object
	 */
	public Object object();

	Object empyObject();

	/**
	 * generate an json_array
	 */
	Object array();

	Object empyArray();

	/**
	 * transform a value to a json_object
	 */
	Object transformV(Object value);

	/**
	 * append a key/value to a json_object
	 */
	void appendObject(Object jsonObject, String key, Object value);

	/**
	 * append a key/value to an json_array
	 */
	void appendArray(Object jsonArray, String key, Object value);

	/**
	 * split bean to collection
	 */
	Collection<? extends Entry<String, ? extends Object>> split(Object bean);
}
