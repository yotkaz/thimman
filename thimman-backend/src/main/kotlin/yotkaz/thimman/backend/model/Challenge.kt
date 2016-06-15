package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
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
        var type: ChallangeType,

        var reference: String? = null,

        @JsonManagedReference
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
    private constructor() : this(
            name = "",
            description = "",
            type = ChallangeType.TASK
    )

}

