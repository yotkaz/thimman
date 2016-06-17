package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Skill(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var name: String,
        var description: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var persons: Set<Person> = HashSet(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var jobOffers: Set<JobOffer> = HashSet()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = "",
            description = ""
    )

}