package yotkaz.thimman.backend.model

import java.util.*
import javax.persistence.Entity

/**
 * Created on 22.04.16.
 */
@Entity
class Employee(
        id: Long?,
        firstName: String,
        lastName: String,
        var employmentDate: Date?
) : Person(id, firstName, lastName) {

    /** JPA needs empty constructor */
    constructor() : this(null, "", "", null) {
    }
}