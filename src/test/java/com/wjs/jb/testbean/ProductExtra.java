/**
 *
 */
package com.wjs.jb.testbean;

/**
 * @author zju_wjf
 * @date 2016年12月13日
 */
public class ProductExtra {

	private String channel;

	private ProductPromotionPolicy[] promotionPolicy;

	public ProductExtra(String channel, ProductPromotionPolicy...promotionPolicy) {
		super();
		this.channel = channel;
		this.promotionPolicy = promotionPolicy;
	}


	/**
	 * 获取channel
	 * @return channel
	 */
	public String getChannel() {
		return channel;
	}


	/**
	 * 设置channel
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}


	/**
	 * 获取promotionPolicy
	 * @return promotionPolicy
	 */
	public ProductPromotionPolicy[] getPromotionPolicy() {
		return promotionPolicy;
	}


	/**
	 * 设置promotionPolicy
	 * @param promotionPolicy
	 */
	public void setPromotionPolicy(ProductPromotionPolicy[] promotionPolicy) {
		this.promotionPolicy = promotionPolicy;
	}



}
