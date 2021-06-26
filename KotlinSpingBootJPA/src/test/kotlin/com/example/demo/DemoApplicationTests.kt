package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class DemoApplicationTests(
	@Autowired private val controller: HelloController
) {

	@Test
	fun contextLoads() {
		println("=================================")
		println("=================================")
		controller.getTrackingPlanByIdLazy("1")
		println("=================================")
		println("=================================")
		controller.getTrackingPlanByIdEager("1")
		println("=================================")
		println("=================================")
	}

}
