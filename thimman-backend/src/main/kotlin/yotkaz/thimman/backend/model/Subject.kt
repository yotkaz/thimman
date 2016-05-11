package yotkaz.thimman.backend.model

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Subject(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long?,

        var name: String,
        var description: String,
        @ManyToMany
        var activities: List<@JvmSuppressWildcards Activity>

)