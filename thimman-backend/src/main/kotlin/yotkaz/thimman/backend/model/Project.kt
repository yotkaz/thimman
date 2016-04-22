package yotkaz.thimman.backend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 22.04.16.
 */
@Entity
class Project(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long?,

        var name: String,
        var description: String
) {

    /** JPA needs empty constructor */
    constructor() : this(null, "", "") {
    }
}