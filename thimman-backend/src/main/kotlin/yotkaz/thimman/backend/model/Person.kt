package yotkaz.thimman.backend.model

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var firstName: String,
        var lastName: String,
        var email: String,
        var phone: String?,
        @Embedded
        var contactAddress: Address?,
        @ManyToMany
        var declaredSkills: Set<Skill>,
        @ManyToMany
        var connectedMeetings: List<Meeting>,
        @OneToMany
        var initiatedMeetings: List<Meeting>

)