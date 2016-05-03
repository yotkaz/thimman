package yotkaz.thimman.backend.model.base

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Activity(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var name: String,
        var description: String,
        var subjects: Set<Subject>

)