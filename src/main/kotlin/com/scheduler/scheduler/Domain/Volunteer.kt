package com.scheduler.scheduler.Domain

import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Volunteer (
    @Id
    @Column(name="email")
    @NotNull
    val email: String = "",

    @Column(name="first_name")
    val firstName: String="",

    @Column(name="last_name")
    val lastName: String=""
)
