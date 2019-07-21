package com.scheduler.scheduler.Domain

import org.jetbrains.annotations.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Volunteer {
    @Id
    @Column(name="email")
    @NotNull
    val email: String = ""
}
