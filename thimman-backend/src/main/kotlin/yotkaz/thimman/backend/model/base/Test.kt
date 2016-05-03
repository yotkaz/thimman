package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Test(

        id: Long? = null,
        name: String,
        description: String,
        subjects: Set<Subject> = HashSet(),
        var questions: List<Question> = ArrayList()

) : Activity(id, name, description, subjects) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING
    )

}