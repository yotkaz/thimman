package yotkaz.thimman.backend.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created on 22.04.16.
 */
@Entity
data class Meeting(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long?,

        var subject: String,
        var place: String,
        var startTime: Date,
        var endTime: Date
)