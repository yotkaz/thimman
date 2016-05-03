package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_DATE
import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Meeting(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var subject: String,
        var place: String,
        var startTime: Date,
        var endTime: Date

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            subject = DEFAULT_STRING,
            place = DEFAULT_STRING,
            startTime = DEFAULT_DATE,
            endTime = DEFAULT_DATE
    )

}