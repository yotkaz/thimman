package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Project(

        id: Long? = null,
        name: String,
        description: String,
        var courses: List<Course> = ArrayList(),
        var materials: List<Material> = ArrayList()

) : Subject(id, name, description) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = "",
            description = ""
    )

}