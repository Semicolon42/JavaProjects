package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan("com.example.demo")
@EnableJpaRepositories("com.example.demo.db")
@SpringBootApplication()
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
