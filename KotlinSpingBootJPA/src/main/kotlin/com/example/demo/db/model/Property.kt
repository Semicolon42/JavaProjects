package com.example.demo.db.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Property (
    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,
) {
    @Id
    var id: Long = 0

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    var eventPropertyEntities: List<EventProperty> = mutableListOf()

    override fun toString(): String {
        return "Property(name='$name', description='$description', id=$id)"
    }
}