package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
class Task(

        id: Long? = null,
        name: String,
        description: String,
        subjects: Set<@JvmSuppressWildcards Subject> = HashSet(),
        @ManyToMany
        var requiredSkills: Set<Skill> = HashSet()

) : Challange(id, name, description, subjects) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING
    )

}