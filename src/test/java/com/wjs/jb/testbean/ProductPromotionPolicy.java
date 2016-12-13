/**
 *
 */
package com.wjs.jb.testbean;

/**
 * @author zju_wjf
 * @date 2016年12月13日
 */
public class ProductPromotionPolicy {
	private String rule;

	public ProductPromotionPolicy(String rule) {
		this.rule = rule;
	}

	/**
	 * 获取rule
	 * @return rule
	 */
	public String getRule() {
		return rule;
	}


	/**
	 * 设置rule
	 * @param rule
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}



}
