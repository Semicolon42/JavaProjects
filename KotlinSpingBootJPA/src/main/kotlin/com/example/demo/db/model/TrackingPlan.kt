package com.example.demo.db.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="tracking_plan")
class TrackingPlan(
    @Id
    var id: Int? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,
) : Serializable {
    @OneToMany(mappedBy = "trackingPlan")
    var events: Set<Event> = mutableSetOf()

    override fun toString(): String {
        return "TrackingPlan(id=$id, name='$name', description='$description', events=$events)"
    }
}