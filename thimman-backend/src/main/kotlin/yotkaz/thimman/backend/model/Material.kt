package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonBackReference
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Material(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        var reference: String,

        @JsonBackReference
        @ManyToMany(fetch = FetchType.LAZY)
        var lessons: List<Lesson> = ArrayList(),

        @JsonBackReference
        @ManyToMany(fetch = FetchType.LAZY)
        var challenges: List<Challenge> = ArrayList(),

        @JsonBackReference
        @ManyToMany(fetch = FetchType.LAZY)
        var jobOffers: List<JobOffer> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = "",
            reference = ""
    )

}