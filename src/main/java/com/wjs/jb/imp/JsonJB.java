/**
 *
 */
package com.wjs.jb.imp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.wjs.jb.JB;
import com.wjs.jb.JBConstants;
import com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @author zju_wjf
 * @date 2016-12-11
 */
public class JsonJB extends JB implements IJBJsonAdapter {

	public JsonJB() {
		this.addFilters(JBConstants.DEFAULT_FILTER);
	}

	@Override
	public String toString() {
		return json().toString();
	}

	@Override
	public Object object() {
		return new JSONObject();
	}

	@Override
	public Object empyObject() {
		return object();
	}

	@Override
	public Object array() {
		return new JSONArray();
	}

	@Override
	public Object empyArray() {
		return array();
	}

	@Override
	public void appendObject(Object jsonObject, String key, Object value) {
		JSONObject jo = (JSONObject) jsonObject;
		jo.put(key, transformV(value));
	}

	@Override
	public void appendArray(Object jsonArray, String key, Object value) {
		JSONArray ja = (JSONArray) jsonArray;
		ja.put(transformV(value));
	}

	@Override
	public Object transformV(Object value) {
		return JSONObject.wrap(value);
	}

	@Override
	protected IJBJsonAdapter jsonAdapter() {
		return this;
	}

	@Override
	public Collection<? extends Entry<String, ? extends Object>> split(Object bean) {
		Object je = this.transformV(bean);
		if(je instanceof JSONObject) {
			JSONObject jo = (JSONObject)je;

			Map<String, Object> map = new HashMap<String, Object>();
			for (final String key : ((JSONObject) je).keySet()) {
                final Object value = jo.get(key);
                map.put(key, value);
            }

			return map.entrySet();
		}
		return null;
	}

}
