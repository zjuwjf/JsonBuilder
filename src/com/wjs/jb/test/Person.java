/**
 *
 */
package com.wjs.jb.test;

/**
 * @author zju_wjf
 * @date 2016��12��11��
 */
public class Person {
	private String name;
	private int age;
	private String location;
	private String sex;

	public Person(String name, int age, String location, String sex) {
		this.name = name;
		this.age = age;
		this.location = location;
		this.sex = sex;
	}


	/**
	 * ��ȡname
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡage
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * ����age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * ��ȡlocation
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * ����location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * ��ȡsex
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * ����sex
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}




}
