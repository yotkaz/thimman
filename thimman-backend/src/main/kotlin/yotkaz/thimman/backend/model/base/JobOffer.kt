package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import javax.persistence.Entity

@Entity
class JobOffer(

        id: Long? = null,
        name: String,
        description: String

) : Subject(id, name, description) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = DEFAULT_STRING,
            description = DEFAULT_STRING
    )

}