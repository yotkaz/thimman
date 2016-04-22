package yotkaz.thimman.backend.model

import javax.persistence.Entity

/**
 * Created on 22.04.16.
 */
@Entity
class Candidate(
        id: Long?,
        firstName: String,
        lastName: String
) : Person(id, firstName, lastName) {

    /** JPA needs empty constructor */
    constructor() : this(null, "", "") {
    }
}