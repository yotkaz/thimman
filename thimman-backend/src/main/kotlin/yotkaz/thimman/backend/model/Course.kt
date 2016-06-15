package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Course(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        @JsonManagedReference
        @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var lessons: List<Lesson> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var projects: List<Project> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var employees: List<Person> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = ""
    )

}