package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Material(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        var reference: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var lessons: List<Lesson> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var challenges: List<Challenge> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        var jobOffers: List<JobOffer> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = "",
            description = "",
            reference = ""
    )

}