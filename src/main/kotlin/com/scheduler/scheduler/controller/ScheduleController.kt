package com.scheduler.scheduler.controller

import com.scheduler.scheduler.Domain.AssignmentWithShift
import com.scheduler.scheduler.Domain.Assignment
import com.scheduler.scheduler.Domain.AssignmentWithVolunteer
import com.scheduler.scheduler.Domain.ShiftWithAvailability
import com.scheduler.scheduler.Repository.AssignmentRepository
import com.scheduler.scheduler.Repository.ScheduleRepository
import com.scheduler.scheduler.Repository.VolunteerRepository
import org.springframework.expression.spel.ast.Assign
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["https://volunteer-admin.apps.pcfone.io"])
@RestController
@RequestMapping("/api")
class ScheduleController(
        val scheduleRepo: ScheduleRepository,
        val assignmentRepo: AssignmentRepository,
        val volunteerRepo: VolunteerRepository
) {

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

    @GetMapping("/assignment", params = ["email"])
    fun getAssignmentByEmail(@RequestParam email: String): List<AssignmentWithShift> {
        val assignments = assignmentRepo.findAllByEmail(email)

        return assignments.map { assignment ->
            val shift = scheduleRepo.findById(assignment.shiftId)
            AssignmentWithShift(assignment, shift.get())
        }
    }

    @GetMapping("/assignment", params = ["shiftId"])
    fun getAssignmentByShift(@RequestParam shiftId: String): Iterable<AssignmentWithVolunteer> {
        val assignments = assignmentRepo.findAllByShiftId(shiftId.toLong())

        return assignments.map { assignment ->
            val volunteer = volunteerRepo.findById(assignment.email)
            AssignmentWithVolunteer(assignment, volunteer.get())
        }
    }

    @GetMapping("/volunteer")
    fun isVolunteer(@RequestParam email: String): Boolean {
        val volunteer = volunteerRepo.findById(email)

       return volunteer.isPresent
    }
}
