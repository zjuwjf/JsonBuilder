/**
 *
 */
package com.wjs.jb;

import java.util.Collection;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @author zju_wjf
 * @date 2016-12-11
 */
public class GsonJB extends AbsJB implements IJBJsonAdapter {

	//格式化
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public GsonJB() {
		this.addFilters(JBConstants.DEFAULT_FILTER);
	}

	@Override
	public JsonElement json() {
		return (JsonElement) super.json();
	}

	@Override
	public String toString() {
		return gson.toJson(json());
	}

	@Override
	public Object object() {
		return new JsonObject();
	}

	@Override
	public Object empyObject() {
		return object();
	}

	@Override
	public Object array() {
		return new JsonArray();
	}

	@Override
	public Object empyArray() {
		return array();
	}

	@Override
	public void appendObject(Object jsonObject, String key, Object value) {
		JsonObject jo = (JsonObject) jsonObject;
		jo.add(key, transformV(value));
	}

	@Override
	public void appendArray(Object jsonArray, String key, Object value) {
		JsonArray ja = (JsonArray) jsonArray;
		ja.add(transformV(value));
	}

	@Override
	public JsonElement transformV(Object value) {
		if (value instanceof JsonElement) {
			return (JsonElement) value;
		} else {
			return gson.toJsonTree(value);
		}
	}

	@Override
	IJBJsonAdapter jsonAdapter() {
		return this;
	}

	@Override
	public Collection< ? extends Entry<String, ? extends Object>> split(Object bean) {
		JsonElement je = this.transformV(bean);
		if(je != null) {
			if(je.isJsonObject()) {
				JsonObject jo = (JsonObject)je;
				return jo.entrySet();
			}
		}
		return null;
	}

}
