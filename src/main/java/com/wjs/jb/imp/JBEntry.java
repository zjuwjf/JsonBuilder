/**
 *
 */
package com.wjs.jb.imp;

/**
 * @author zju_wjf
 * @date 2016��12��10��
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
	 * ��ȡkey
	 *
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * ����key
	 *
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * ��ȡvalue
	 *
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * ����value
	 *
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
