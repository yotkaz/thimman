package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Material(

        id: Long? = null,
        name: String,
        description: String,
        subjects: Set<@JvmSuppressWildcards Subject> = HashSet(),
        link: String

) : Activity(id, name, description, subjects) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING,
            link = DEFAULT_STRING
    )

}