package com.example.demo

import com.example.demo.db.model.Employee
import com.example.demo.db.EmployeeRepository
import com.example.demo.db.model.TrackingPlan
import com.example.demo.db.TrackingPlanRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    companion object {
        val LOG: Logger = this.logger()
    }


    @Autowired
    private val employeeRepository: EmployeeRepository? = null
    @Autowired
    private val trackingPlanRepository: TrackingPlanRepository? = null

    @GetMapping("/")
    fun index(): String {
        LOG.info("Greetings from Spring Boot! " + "HelloController")
        return "Greetings from Spring Boot!"
    }

    @GetMapping("/employee/name/{name}")
    fun getEmployeeByName(@PathVariable name: String?): ResponseEntity<Employee> {
        LOG.info("getting employee $name")
        val employee = employeeRepository!!.findByName(name)
        return ResponseEntity<Employee>(employee, HttpStatus.OK)
    }

    @GetMapping("/employee/email/{email}")
    fun getEmployeeByEmail(@PathVariable email: String?): ResponseEntity<Employee> {
        LOG.info("getting employee $email")
        val employee = employeeRepository!!.findByEmail(email)
        return ResponseEntity<Employee>(employee, HttpStatus.OK)
    }

    @GetMapping("/tracking_plan/lazy/{id}")
    fun getTrackingPlanByIdLazy(@PathVariable id: String?): ResponseEntity<TrackingPlan> {
        LOG.info("\n========\n========\n========" + "\n========\n========\n========")
        LOG.info("LAZY getting tracking plan for $id")
        var id_l = id?.toInt()
        val startTime = System.currentTimeMillis()
        val trackingPlan = trackingPlanRepository!!.findById(id_l)
        LOG.info("FETCHED: ${ObjectMapper().writeValueAsString(trackingPlan)}");
        LOG.info("Total Time: " + (System.currentTimeMillis() - startTime))
        LOG.info("\n========\n========\n========" + "\n========\n========\n========")
        return ResponseEntity<TrackingPlan>(trackingPlan, HttpStatus.OK)
    }

    @GetMapping("/tracking_plan/{id}")
    fun getTrackingPlanByIdEager(@PathVariable id: String?): ResponseEntity<TrackingPlan> {
        LOG.info("\n========\n========\n========" + "\n========\n========\n========")
        LOG.info("EAGER getting tracking plan for $id")
        val startTime = System.currentTimeMillis()
        var id_l = id?.toInt()
        val trackingPlan = trackingPlanRepository!!.findByIdEager(id_l)
        trackingPlan.forEach {LOG.info("FETCHED: ${ObjectMapper().writeValueAsString(it)}")}
        LOG.info("Total Time: " + (System.currentTimeMillis() - startTime))
        LOG.info("\n========\n========\n========" + "\n========\n========\n========")
        return ResponseEntity<TrackingPlan>(trackingPlan.firstOrNull(), HttpStatus.OK)
    }
}