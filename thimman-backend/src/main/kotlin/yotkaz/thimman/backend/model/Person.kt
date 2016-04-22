package yotkaz.thimman.backend.model

import javax.persistence.*

/**
 * Created on 22.04.16.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long? = null,

        var firstName: String,
        var lastName: String
) {
    /** JPA needs empty constructor */
    constructor() : this(null, "", "") {
    }
}

