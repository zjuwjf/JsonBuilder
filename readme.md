#JsonBuilder
### a very fast and convenient tool to build a json without a break!
	


## Simples

### EmptyObject
		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
		.eo();
		//@formatter:on

		log(jb);
#### output
		{}

###### .
### EmptyArray
		final JB jb = new GsonJB();
		//@formatter:off
		jb.a()
		.ea();
		//@formatter:on

		log(jb);
#### output
		[]

###### .
### SimpleObject
		final JB jb = new GsonJB();
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
#### output
		{
		  "name": "lingoes",
		  "age": 18,
		  "contact": {
		    "tel": "0571-88888888",
		    "QQ": "3141592653",
		    "wechat": "lingoes"
		  }
		}

###### .
### SimpleArray
		final JB jb = new GsonJB();
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
#### output
		[
		  1,
		  2,
		  3,
		  [
		    1,
		    4,
		    9
		  ]
		]

###### .
### ObjectIf
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11"), 120);

		final JB jb = new GsonJB();
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
#### output
		{
		  "productName": "Noodle",
		  "placeOfOrigin": "China-HangZhou",
		  "expirationDate": "Out Of Date",
		  "price": 120.0
		}

###### .
### ArrayIf
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11"), 120);

		final JB jb = new GsonJB();
		//@formatter:off
		jb.a()
			.v(product.getProductName())
			.v(product.getPlaceOfOrigin())
			.if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
			.else_()
				.v(product.getExpirationDate())
			.eif()
			.v(product.getPrice())
		.ea();
		//@formatter:on

		log(jb);
#### output
		[
		  "Noodle",
		  "China-HangZhou",
		  "Out Of Date",
		  120.0
		]

###### .
### KeyIf
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2016-11-11"), 120);

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("productName").v(product.getProductName())
			.k("placeOfOrigin").v(product.getPlaceOfOrigin())
			.k("expirationDate").if_(product.getExpirationDate().before(new Date()))
				.v("Out Of Date")
			.else_()
				.v(product.getExpirationDate())
			.eif()
			.k("price").v(product.getPrice())
		.eo();
		//@formatter:on

		log(jb);
#### output
		{
		  "productName": "Noodle",
		  "placeOfOrigin": "China-HangZhou",
		  "expirationDate": "Out Of Date",
		  "price": 120.0
		}


###### .
### EmptyArray
		final JB jb = new GsonJB();
		//@formatter:off
		jb.a()
		.ea();
		//@formatter:on

		log(jb);
#### output

###### .
### EmptyArray
		final JB jb = new GsonJB();
		//@formatter:off
		jb.a()
		.ea();
		//@formatter:on

		log(jb);
#### output

###### .
### ObjectFor
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("square-table").o()
				.for_(array)
					.it((i, v)->{ return new JBEntry(v+"*"+v,v*v); })
				.efor()
			.eo()
		.eo();
		//@formatter:on

		log(jb);
#### output
		{
		  "square-table": {
		    "1*1": 1,
		    "2*2": 4,
		    "3*3": 9,
		    "4*4": 16,
		    "5*5": 25,
		    "6*6": 36,
		    "7*7": 49,
		    "8*8": 64,
		    "9*9": 81
		  }
		}

###### .
### ArrayFor
		Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.k("square-list").a()
				.for_(array)
					.it((v)->{return v*v;})
				.efor()
			.ea()
		.eo();
		//@formatter:on

		log(jb);
#### output
		{
		  "square-list": [
		    1,
		    4,
		    9,
		    16,
		    25,
		    36,
		    49,
		    64,
		    81
		  ]
		}

###### .
### ObjectParse
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"), 120);
		ProductExtra productExtra = new ProductExtra("taobao");
		ProductPromotionPolicy promotionPolicy = new ProductPromotionPolicy("满100减30");

		final JB jb = new GsonJB();
		//@formatter:off
		jb.o()
			.parse(product)
			.parse(productExtra)
			.parse(promotionPolicy)
		.eo();
		//@formatter:on

		log(jb);
#### output
		{
		  "productName": "Noodle",
		  "placeOfOrigin": "China-HangZhou",
		  "expirationDate": "Nov 11, 2017 12:00:00 AM",
		  "price": 120.0,
		  "channel": "taobao",
		  "promotionPolicy": [],
		  "rule": "满100减30"
		}

###### .
### ArrayParse
		Product product = new Product("Noodle", "China-HangZhou", new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-11"), 120);
		ProductExtra productExtra = new ProductExtra("taobao");
		ProductPromotionPolicy promotionPolicy0 = new ProductPromotionPolicy("满100减30");
		ProductPromotionPolicy promotionPolicy1 = new ProductPromotionPolicy("满300减100");
		ProductPromotionPolicy promotionPolicy2 = new ProductPromotionPolicy("满500减200");

		final JB jb = new GsonJB();
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
#### output
		{
		  "productName": "Noodle",
		  "placeOfOrigin": "China-HangZhou",
		  "expirationDate": "Nov 11, 2017 12:00:00 AM",
		  "price": 120.0,
		  "channel": "taobao",
		  "promotionPolicy": [
		    {
		      "rule": "满100减30"
		    },
		    {
		      "rule": "满300减100"
		    },
		    {
		      "rule": "满500减200"
		    }
		  ]
		}