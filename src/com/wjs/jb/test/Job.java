/**
 *
 */
package com.wjs.jb.test;

/**
 * @author zju_wjf
 * @date 2016年12月11日
 */
public class Job {
	private String tile;
	private String department;
	private int salary;

	public Job() {
		this.tile = "intermediate-coder";
		this.department = "IT-Dev";
		this.salary = 10000;
	}

	/**
	 * 获取tile
	 * @return tile
	 */
	public String getTile() {
		return tile;
	}

	/**
	 * 设置tile
	 * @param tile
	 */
	public void setTile(String tile) {
		this.tile = tile;
	}

	/**
	 * 获取department
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 设置department
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 获取salary
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * 设置salary
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}



}
