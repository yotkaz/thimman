package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.*

@Entity
data class JobOfferChallenge(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        @ManyToOne
        var jobOffer: JobOffer?,

        @ManyToOne
        var challenge: Challenge?,

        @Embedded
        var challengeAttributes: ChallengeAttributes? = null

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            jobOffer = null,
            challenge = null
    )

}