package com.scheduler.scheduler.Domain

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
data class Shift(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="primary_id")
    val primaryId: Long = 0,

    @Column(name="hour_start")
    @NotNull
    val hourStart: Long=0,

    @Column(name="day")
    @NotNull
    val day: String="",

    @Column(name="total_slots")
    @NotNull
    val totalSlots: Long=0
)
