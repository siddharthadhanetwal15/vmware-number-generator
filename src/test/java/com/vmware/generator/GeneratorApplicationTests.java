package com.vmware.generator;

import com.vmware.generator.service.TaskSvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneratorApplicationTests {
	@Autowired
	TaskSvc taskSvc;

	@Test
	void contextLoads() {
	}

	@Test
	void performTask(){

	}
}
