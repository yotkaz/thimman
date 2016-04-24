package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

/**
 * Created on 22.04.16.
 */
@Entity
class Employee(
        id: Long? = null,
        firstName: String,
        lastName: String,
        var employmentDate: Date?
) : Person(id, firstName, lastName) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(null, "", "", null) {
    }
}