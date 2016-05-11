package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_DATE
import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
class Meeting(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var subject: String,
        var place: String,
        var startTime: Date,
        var endTime: Date,
        @OneToOne
        var initiator: Person?,
        @ManyToMany
        var persons: Set<@JvmSuppressWildcards Person>

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            subject = DEFAULT_STRING,
            place = DEFAULT_STRING,
            startTime = DEFAULT_DATE,
            endTime = DEFAULT_DATE,
            initiator = null,
            persons = HashSet()
    )

}