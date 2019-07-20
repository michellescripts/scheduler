package com.scheduler.scheduler.controller

import com.scheduler.scheduler.Domain.Assignment
import com.scheduler.scheduler.Domain.ShiftWithAvailability
import com.scheduler.scheduler.Repository.AssignmentRepository
import com.scheduler.scheduler.Repository.ScheduleRepository
import org.springframework.web.bind.annotation.*

@RestController
class ScheduleController(val scheduleRepo: ScheduleRepository, val assignmentRepo: AssignmentRepository) {

    @GetMapping("/shifts")
    fun getShifts(): List<ShiftWithAvailability> {
        val allShifts = scheduleRepo.findAll()

        return allShifts.map { shift ->
            val assignmentsForShift = assignmentRepo.findAllByShiftId(shift.primaryId)
            ShiftWithAvailability(shift, shift.totalSlots - assignmentsForShift.count())
        }
    }

    @PostMapping("/assignment")
    fun postAssignment(@RequestBody assignment: Assignment) {
        assignmentRepo.save(assignment)
    }

    @DeleteMapping("/assignment/{id}")
    fun deleteAssignment(@PathVariable id: Long) {
        assignmentRepo.deleteById(id)
    }


    //todo  delete a persons entire assignment
}