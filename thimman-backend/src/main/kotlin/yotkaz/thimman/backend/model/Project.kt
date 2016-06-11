package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Project(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var courses: List<Course> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var employees: List<Person> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var jobOffers: List<JobOffer> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = ""
    )

}