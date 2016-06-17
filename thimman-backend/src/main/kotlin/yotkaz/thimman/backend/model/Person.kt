package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var firstName: String,

        var lastName: String,

        @Embedded
        var contactAddress: Address?,

        var email: String,

        var phone: String? = null,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var types: Set<@JvmSuppressWildcards PersonType>,

        var cv: String? = null,

        var employmentDate: LocalDateTime? = null,

        @JsonIgnore
        @OneToOne(fetch = FetchType.EAGER)
        var user: User?,

        @ManyToMany(fetch = FetchType.EAGER)
        var declaredSkills: List<Skill>,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var connectedMeetings: List<Meeting> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var initiatedMeetings: List<Meeting> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var jobOffers: List<JobOffer> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var projects: List<Project> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var courses: List<Course> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var attempts: List<Attempt> = ArrayList(),

        @JsonIgnore
        @OneToMany(fetch = FetchType.LAZY)
        var ratedAttempts: List<Attempt> = ArrayList(),

        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY)
        var challengesAvailableToRate: List<Challenge> = ArrayList()

) {

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            firstName = "",
            lastName = "",
            contactAddress = null,
            email = "",
            types = HashSet(),
            user = null,
            declaredSkills = ArrayList()
    )

}