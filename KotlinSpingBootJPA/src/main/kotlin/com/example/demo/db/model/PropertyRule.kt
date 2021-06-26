package com.example.demo.db.model

import org.hibernate.annotations.Type
import javax.persistence.*

class PropertyRuleEntity(
    @Column(name = "rule")
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    var rule: ValidationRule,

    @Column(name = "value")
    var value: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    var property: Property? = null
}