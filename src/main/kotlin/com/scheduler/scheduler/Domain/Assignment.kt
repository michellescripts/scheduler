package com.scheduler.scheduler.Domain

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
data class Assignment(
        @Column(name = "primary_id")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val primaryId: Long = 0,

        @Column(name = "email")
        @NotNull
        val email: String = "",

        @Column(name = "shift_id")
        @NotNull
        val shiftId: Long = 0
)
