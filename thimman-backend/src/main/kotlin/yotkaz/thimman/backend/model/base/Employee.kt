package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_DATE
import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Employee(

        id: Long? = null,
        firstName: String,
        lastName: String,
        var employmentDate: Date

) : Person(id, firstName, lastName) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            firstName = DEFAULT_STRING,
            lastName = DEFAULT_STRING,
            employmentDate = DEFAULT_DATE
    )

}