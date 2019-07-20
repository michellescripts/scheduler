package com.scheduler.scheduler.Repository

import com.scheduler.scheduler.Domain.Shift
import org.springframework.data.repository.CrudRepository

interface ScheduleRepository : CrudRepository<Shift, Long> {

}
