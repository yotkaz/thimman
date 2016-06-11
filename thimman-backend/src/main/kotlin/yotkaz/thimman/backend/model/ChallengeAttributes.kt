package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Embeddable

@Embeddable
data class ChallengeAttributes(

    var passMark: Double?,
    var maxAttempts: Int?

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            passMark = 0.0,
            maxAttempts = 0
    )

}