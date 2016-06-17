package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Challenge(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        @Enumerated(EnumType.STRING)
        var type: ChallengeType,

        var reference: String? = null,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var materials: List<Material> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var attempts: List<Attempt> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var jobOfferChallenges: List<JobOfferChallenge> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var lessonChallenges: List<LessonChallenge> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = "",
            description = "",
            type = ChallengeType.TASK
    )

}

