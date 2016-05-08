package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Project(

        id: Long? = null,
        name: String,
        description: String,
        activities: List<@JvmSuppressWildcards Activity>,
        @ManyToMany
        var courses: List<Course> = ArrayList(),
        @ManyToMany
        var materials: List<Material> = ArrayList()

) : Subject(id, name, description, activities) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            description = "",
            activities = ArrayList()
    )

}