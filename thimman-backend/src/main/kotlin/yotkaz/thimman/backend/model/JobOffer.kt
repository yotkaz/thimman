package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 22.04.16.
 */
@Entity
class JobOffer(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long? = null,

        var name: String,
        var description: String
) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(null, "", "") {
    }
}