/**
 *
 */
package com.wjs.jb.test;

/**
 * @author zju_wjf
 * @date 2016年12月11日
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
	 * 获取name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 获取location
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 设置location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 获取sex
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置sex
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}




}
