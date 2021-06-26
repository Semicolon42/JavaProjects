package com.example.demo.db.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
class Event(
    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String

    ) : Serializable {

    @Id
    var id: Long = 0

    @OneToMany(mappedBy = "event", targetEntity = EventProperty::class, fetch = FetchType.EAGER)
    var eventProperties: Set<EventProperty> = mutableSetOf()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_plan_id")
    @JsonIgnore
    lateinit var trackingPlan: TrackingPlan

    override fun toString(): String {
        return "Event(name='$name', description='$description', id=$id, eventProperties=$eventProperties)"
    }
}