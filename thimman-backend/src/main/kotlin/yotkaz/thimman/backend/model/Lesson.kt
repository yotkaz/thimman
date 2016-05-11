package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Lesson(

        id: Long? = null,
        name: String,
        description: String,
        activities: List<@JvmSuppressWildcards Activity>

) : Subject(id, name, description, activities) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING,
            activities = ArrayList()
    )

}