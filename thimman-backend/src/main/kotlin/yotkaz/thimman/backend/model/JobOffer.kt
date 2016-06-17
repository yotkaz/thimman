package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class JobOffer(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        @Enumerated(EnumType.STRING)
        var status: JobOfferStatus,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var materials: List<Material> = ArrayList(),

        @ManyToMany(fetch = FetchType.EAGER)
        var requiredSkills: List<Skill> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var candidates: List<Person> = ArrayList(),

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        var project: Project?,

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var challenges: List<JobOfferChallenge> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = "",
            description = "",
            status = JobOfferStatus.AVAILABLE,
            project = null
    )

}