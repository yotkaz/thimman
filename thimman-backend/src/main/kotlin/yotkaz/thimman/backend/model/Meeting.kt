package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Meeting(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var subject: String,

        var description: String,

        var place: String,

        var startTime: LocalDateTime,

        var endTime: LocalDateTime,

        @OneToOne(fetch = FetchType.EAGER)
        var initiator: Person?,

        @ManyToMany(fetch = FetchType.EAGER)
        var persons: List<Person>

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            subject = "",
            description = "",
            place = "",
            startTime = LocalDateTime.now(),
            endTime = LocalDateTime.now(),
            initiator = null,
            persons = ArrayList()
    )

}