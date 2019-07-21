package com.scheduler.scheduler.Repository

import com.scheduler.scheduler.Domain.Assignment
import org.springframework.data.repository.CrudRepository

interface AssignmentRepository : CrudRepository<Assignment, Long> {
    fun findAllByShiftId(shiftId: Long): Iterable<Assignment>
    fun findAllByEmail(email: String): Iterable<Assignment>
}
