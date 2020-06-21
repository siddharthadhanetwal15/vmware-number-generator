package com.vmware.generator;

import com.vmware.generator.repository.TaskRepository;
import com.vmware.generator.service.impl.TaskSvcImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class GeneratorApplicationTests {
	@InjectMocks
	private TaskSvcImpl taskSvc;

	@Mock
	private TaskRepository taskRepository;

	/**
	 * below are the test cases for testing this app. We need to mock the object and then assert with the answer
	 */

	@Test
	void performTaskTest(){

	}

	@Test
	void performTaskInvalidBodyTest(){

	}

	@Test
	void getTaskStatusTest(){

	}

	@Test
	void getNumListTest(){

	}

	@Test
	void getNumListInvalidUUIDTest(){

	}
}
