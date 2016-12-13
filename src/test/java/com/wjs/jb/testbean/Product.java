/**
 *
 */
package com.wjs.jb.testbean;

import java.util.Date;

/**
 * @author zju_wjf
 * @date 2016年12月13日
 */
public class Product {

	private String productName;

	private String placeOfOrigin;

	private Date expirationDate;

	private double price;

	public Product(String productName, String placeOfOrigin, Date expirationDate, double price) {
		super();
		this.productName = productName;
		this.placeOfOrigin = placeOfOrigin;
		this.expirationDate = expirationDate;
		this.price = price;
	}

	/**
	 * 获取placeOfOrigin
	 *
	 * @return placeOfOrigin
	 */
	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	/**
	 * 设置placeOfOrigin
	 *
	 * @param placeOfOrigin
	 */
	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	/**
	 * 获取productName
	 *
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置productName
	 *
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 获取expirationDate
	 *
	 * @return expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * 设置expirationDate
	 *
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * 获取price
	 *
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 设置price
	 *
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
