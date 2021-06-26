package com.example.demo.db

import com.example.demo.db.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee?, Int?> {
    fun findByName(name: String?): Employee?
    fun findByEmail(email: String?): Employee?
}