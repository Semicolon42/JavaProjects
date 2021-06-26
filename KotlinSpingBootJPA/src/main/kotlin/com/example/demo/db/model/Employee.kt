package com.example.demo.db.model

import javax.persistence.*

@Entity
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    var name: String? = null

    @Column(name = "email_address")
    var email: String? = null

    constructor() {}
    constructor(id: Int?, name: String?, email: String?) {
        this.id = id
        this.name = name
        this.email = email
    }
}