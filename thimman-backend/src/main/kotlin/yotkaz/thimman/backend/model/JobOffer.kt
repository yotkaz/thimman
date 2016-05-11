package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
class JobOffer(

        id: Long? = null,
        name: String,
        description: String,
        activities: List<@JvmSuppressWildcards Activity>,
        @Enumerated(EnumType.STRING)
        var status: JobOfferStatus,
        @ManyToMany
        var requiredSkills: Set<Skill>,
        @ManyToMany
        var candidates: Set<Candidate>

) : Subject(id, name, description, activities) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING,
            activities = ArrayList(),
            status = JobOfferStatus.AVAILABLE,
            requiredSkills = HashSet(),
            candidates = HashSet()
    )

}