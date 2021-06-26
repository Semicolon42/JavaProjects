package com.example.demo.db

import com.example.demo.db.model.TrackingPlan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface TrackingPlanRepository : JpaRepository<TrackingPlan?, Int?> {
    fun findById(id: Int?): TrackingPlan?

    @Query(value="select tp from TrackingPlan tp " +
            "left join fetch tp.events e " +
            "left join fetch e.eventProperties ep " +
            "left join fetch ep.property " +
            "where tp.id=(:id)")
    fun findByIdEager(@Param("id") id: Int?): Set<TrackingPlan>
}