package yotkaz.thimman.backend.model.base

import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var firstName: String,
        var lastName: String,
        var declaredSkills: Set<Skill> = HashSet()

)