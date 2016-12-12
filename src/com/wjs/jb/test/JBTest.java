/**
 *
 */
package com.wjs.jb.test;

import com.wjs.jb.GsonJB;

/**
 * @author zju_wjf
 * @date 2016年12月11日
 */
public class JBTest {

	public static void main(String[] args) {
		// data - prepared
		String language = "Chinese";

		Person person1 = new Person("Jackson", 24, "China-HangZhou", "male");
		Person person2 = new Person("Adalbe", 18, "Am", "female");

		// check - throw

		Job job = new Job();

		// build - json
		final GsonJB jb = new GsonJB();

//		@formatter:off
		jb.o()
			.if_(person1.getAge() == 22)
				.parse(person1)
			.else_()
				.parse(person2)
			.eif()
			.parse(job)
			.k("date1").v("2016-11-11")
			.k("date2").v("2016-12-12")
			.k("words").a()
				.if_("English".equalsIgnoreCase(language))
					.parse("hello", "world", "...")
				.elseif("Chinese".equalsIgnoreCase(language))
					.parse("你好", "世界", "...")
				.else_()
					.parse("??", "??", "...")
				.eif()
				.v("-------")
			.ea()
			.k("words").o()
			.eo()
		.eo();
//		@formatter:on

		final Object value = jb.json();
		System.err.println(value);
	}

}
