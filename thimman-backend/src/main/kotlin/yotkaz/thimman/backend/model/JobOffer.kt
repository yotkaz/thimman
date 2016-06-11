package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
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

        @JsonManagedReference
        @ManyToMany
        var materials: List<Material> = ArrayList(),

        @JsonManagedReference
        @ManyToMany
        var requiredSkills: List<Skill>,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var candidates: List<Person> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var projects: List<Project> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var challenges: List<JobOfferChallenge> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = "",
            status = JobOfferStatus.AVAILABLE,
            requiredSkills = ArrayList()
    )

}