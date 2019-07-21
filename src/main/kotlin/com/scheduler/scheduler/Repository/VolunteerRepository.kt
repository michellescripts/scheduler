package com.scheduler.scheduler.Repository

import com.scheduler.scheduler.Domain.Volunteer
import org.springframework.data.repository.CrudRepository


interface VolunteerRepository: CrudRepository<Volunteer, String>
