package yotkaz.thimman.backend.model

import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created on 22.04.16.
 */
@Entity
data class Meeting(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var subject: String,
        var place: String,
        var startTime: Date?,
        var endTime: Date?
) {
    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(null, "", "", null, null) {
    }
}