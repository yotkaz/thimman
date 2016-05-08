package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Entity

@Entity
class Candidate(

        id: Long? = null,
        firstName: String,
        lastName: String,
        var cvLink: String

) : Person(id, firstName, lastName) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            firstName = DEFAULT_STRING,
            lastName = DEFAULT_STRING,
            cvLink = DEFAULT_STRING
    )

}