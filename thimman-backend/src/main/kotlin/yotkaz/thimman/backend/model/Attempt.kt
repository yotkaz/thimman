package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.*

@Entity
data class Attempt(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var rated: Boolean,

        var score: Double?,

        @ManyToOne
        var person: Person?,

        @ManyToOne(fetch = javax.persistence.FetchType.EAGER)
        var challenge: Challenge?,

        @ManyToOne(fetch = FetchType.EAGER)
        var employeeWhichRated: Person? = null

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            rated = false,
            score = 0.0,
            person = null,
            challenge = null
    )

}