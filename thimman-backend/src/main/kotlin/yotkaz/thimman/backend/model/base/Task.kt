package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Task(

        id: Long? = null,
        name: String,
        description: String,
        subjects: Set<Subject> = HashSet(),
        var requiredSkills: Set<Subject> = HashSet()

) : Activity(id, name, description, subjects) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING
    )

}