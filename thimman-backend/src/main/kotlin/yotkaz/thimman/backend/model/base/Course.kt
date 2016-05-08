package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Course(

        id: Long? = null,
        name: String,
        description: String,
        activities: List<@JvmSuppressWildcards Activity>,
        @ManyToMany
        var lessons: List<Lesson>,
        @ManyToMany
        var materials: List<Material> = ArrayList()

) : Subject(id, name, description, activities) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING,
            activities = ArrayList(),
            lessons = ArrayList()
    )

}