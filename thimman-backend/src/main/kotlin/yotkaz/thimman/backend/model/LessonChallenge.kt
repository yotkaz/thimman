package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.*

@Entity
data class LessonChallenge(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        var lesson: Lesson?,

        @ManyToOne(fetch = FetchType.EAGER)
        var challenge: Challenge?,

        @Embedded
        var challengeAttributes: ChallengeAttributes? = null

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            lesson = null,
            challenge = null
    )

}