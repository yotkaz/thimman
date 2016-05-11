package yotkaz.thimman.backend.model.base

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Subject(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?,

        var name: String,
        var description: String,
        @ManyToMany
        var activities: List<@JvmSuppressWildcards Activity>

)