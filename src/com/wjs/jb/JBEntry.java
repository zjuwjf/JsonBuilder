/**
 *
 */
package com.wjs.jb;

/**
 * @author zju_wjf
 * @date 2016年12月10日
 */
public class JBEntry {
	private String key;
	private Object value;

	public JBEntry(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	JBEntry() {
		this(null, null);
	}

	/**
	 * 获取key
	 *
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 设置key
	 *
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 获取value
	 *
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 设置value
	 *
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
