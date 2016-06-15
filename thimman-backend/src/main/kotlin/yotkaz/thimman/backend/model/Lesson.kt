package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.*

@Entity
data class Lesson(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        var name: String,

        var description: String,

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        var course: Course?,

        @JsonManagedReference
        @ManyToMany(fetch = FetchType.EAGER)
        var materials: List<Material> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var challenges: List<LessonChallenge> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = "",
            course = null
    )

}