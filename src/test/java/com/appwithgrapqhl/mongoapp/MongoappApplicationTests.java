package com.appwithgrapqhl.mongoapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MongoappApplicationTests.class)
class MongoappApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("contexto cargado");
	}

}
