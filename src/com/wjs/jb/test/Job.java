/**
 *
 */
package com.wjs.jb.test;

/**
 * @author zju_wjf
 * @date 2016��12��11��
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
	 * ��ȡtile
	 * @return tile
	 */
	public String getTile() {
		return tile;
	}

	/**
	 * ����tile
	 * @param tile
	 */
	public void setTile(String tile) {
		this.tile = tile;
	}

	/**
	 * ��ȡdepartment
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * ����department
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * ��ȡsalary
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * ����salary
	 * @param salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}



}
