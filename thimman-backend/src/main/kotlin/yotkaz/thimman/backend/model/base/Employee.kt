package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_DATE
import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity

@Entity
class Employee(

        id: Long? = null,
        firstName: String,
        lastName: String,
        email: String,
        phone: String? = null,
        contactAddress: Address?,
        declaredSkills: Set<Skill>,
        connectedMeetings: List<Meeting>,
        initiatedMeetings: List<Meeting>,
        var employmentDate: Date

) : Person(id, firstName, lastName, email, phone, contactAddress,
        declaredSkills, connectedMeetings, initiatedMeetings) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            firstName = DEFAULT_STRING,
            lastName = DEFAULT_STRING,
            email = DEFAULT_STRING,
            contactAddress = null,
            declaredSkills = HashSet(),
            connectedMeetings = ArrayList(),
            initiatedMeetings = ArrayList(),
            employmentDate = DEFAULT_DATE
    )

}