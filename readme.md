#JsonBuilder
### a faset and convenient tool to build a json without a break!
	


## data - prepared
		String language = "Chinese";

		Person person1 = new Person("Jackson", 24, "China-HangZhou", "male");
		Person person2 = new Person("Adalbe", 18, "Am", "female");
		
		Job job = new Job();
## check - throw
		
		

## build - json
		final GsonJB jb = new GsonJB();

		//@formatter:off
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
		//@formatter:on

		final Object value = jb.json();
		System.err.println(value);

## output
		{
		    "name": "Adalbe", 
		    "age": 18, 
		    "location": "Am", 
		    "sex": "female", 
		    "tile": "intermediate-coder", 
		    "department": "IT-Dev", 
		    "salary": 10000, 
		    "date1": "2016-11-11", 
		    "date2": "2016-12-12", 
		    "words": [
		        "你好", 
		        "世界", 
		        "...", 
		        "-------"
		    ]
		}