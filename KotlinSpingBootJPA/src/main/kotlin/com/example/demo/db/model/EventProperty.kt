package com.example.demo.db.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
class EventProperty(
    @EmbeddedId
    var id: EventPropertyPK,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    @JsonIgnore
    var event: Event? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("propertyId")
    @JoinColumn(name = "property_id")
    var property: Property? = null,

    @Column(name = "description")
    var description: String? = null,
) {

    override fun toString(): String {
        return "EventProperty(id=$id, event_id=${event?.id}, property=$property)"
    }
}


@Embeddable
class EventPropertyPK(
    @Column(name = "event_id")
    var eventId: Long,
    @Column(name = "property_id")
    var propertyId: Long
) : Serializable {
    override fun toString(): String {
        return "EventPropertyPK(eventId=$eventId, propertyId=$propertyId)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventPropertyPK

        if (propertyId != other.propertyId) return false
        if (eventId != other.eventId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + eventId.hashCode()
        result = 31 * result + propertyId.hashCode()
        return result
    }
}