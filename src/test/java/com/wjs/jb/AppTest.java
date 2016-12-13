package com.wjs.jb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wjs.jb.testbean.Product;
import com.wjs.jb.testbean.ProductExtra;
import com.wjs.jb.testbean.ProductPromotionPolicy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	private final void log(Object value) {
		Throwable throwable = new Throwable();
		StackTraceElement stackTraceElement = throwable.getStackTrace()[1];
		System.out.println("------" + stackTraceElement.getMethodName() + "------");
		System.out.println(value);
		System.out.println();
	}

	public void testEmptyObject() {
		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.o()
		.eo();
		//@formatter:on

		log(jb);
	}

	public void testObject() {
		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("name").v("lingoes")
			.k("age").v(18)
			.k("contact").o()
				.k("tel").v("0571-88888888")
				.k("QQ").v("3141592653")
				.k("wechat").v("lingoes")
			.eo()
		.eo();
		//@formatter:on

		log(jb);
	}

	public void testEmptyArray() {
		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.a()
		.ea();
		//@formatter:on

		log(jb);
	}

	public void testArray() {
		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.a()
			.v(1)
			.v(2)
			.v(3)
			.a()
				.v(1)
				.v(4)
				.v(9)
			.ea()
		.ea();
		//@formatter:on

		log(jb);
	}

	public void testIf() throws ParseException {
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11"), 120);

		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("productName").v(product.getProductName())
			.k("placeOfOrigin").v(product.getPlaceOfOrigin())
			.if_(product.getExpirationDate().before(new Date()))
				.k("expirationDate").v("Out Of Date")
			.else_()
				.k("expirationDate").v(product.getExpirationDate())
			.eif()
			.k("price").v(product.getPrice())
		.eo();
		//@formatter:on

		log(jb);
	}

	public void testFor() {
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("square-list").a()
				.for_(array)
					.it((v)->{return v*v;})
				.efor()
			.ea()
			.k("square-table").o()
				.for_(array)
					.it((i, v)->{return new JBEntry(v+"*"+v,v*v);})
				.efor()
			.eo()
		.eo();
		//@formatter:on

		log(jb);
	}

	public void testParse() throws ParseException {
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"), 120);
		ProductExtra productExtra = new ProductExtra("taobao");
		ProductPromotionPolicy promotionPolicy0 = new ProductPromotionPolicy("满100减30");
		ProductPromotionPolicy promotionPolicy1 = new ProductPromotionPolicy("满300减100");
		ProductPromotionPolicy promotionPolicy2 = new ProductPromotionPolicy("满500减200");

		final GsonJB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.parse(product)
			.parse(productExtra)
			.k("promotionPolicy").a()
				.parse(promotionPolicy0, promotionPolicy1, promotionPolicy2)
			.ea()
		.eo();
		//@formatter:on

		log(jb);
	}
}
