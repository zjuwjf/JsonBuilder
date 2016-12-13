/**
 *
 */
package com.wjs.jb.imp;

import java.util.Collection;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wjs.jb.JB;
import com.wjs.jb.JBConstants;
import com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @author zju_wjf
 * @date 2016-12-11
 */
public class FastJsonJB extends JB implements IJBJsonAdapter {

	public FastJsonJB() {
		this.addFilters(JBConstants.DEFAULT_FILTER);
	}

	@Override
	public JSON json() {
		return (JSON) super.json();
	}

	@Override
	public String toString() {
		return json().toJSONString();
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
		ja.add(transformV(value));
	}

	@Override
	public Object transformV(Object value) {
		if (value instanceof JSON) {
			return value;
		} else {
			return JSON.toJSON(value);
		}
	}

	@Override
	protected IJBJsonAdapter jsonAdapter() {
		return this;
	}

	@Override
	public Collection< ? extends Entry<String, ? extends Object>> split(Object bean) {
		Object je = this.transformV(bean);
		if(je != null) {
			if(je instanceof JSONObject) {
				JSONObject jo = (JSONObject)je;
				return jo.entrySet();
			}
		}
		return null;
	}

}
