package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonBackReference
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Skill(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var name: String,
        var description: String,

        @JsonBackReference
        @ManyToMany(fetch = FetchType.EAGER)
        var persons: Set<Person> = HashSet(),

        @JsonBackReference
        @ManyToMany(fetch = FetchType.EAGER)
        var jobOffers: Set<JobOffer> = HashSet()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = ""
    )

}