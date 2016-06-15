package yotkaz.thimman.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
open class User(

        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        var id: Long? = null,

        @Column(unique = true)
        var name: String,

        @JsonIgnore
        var password: String,

        var registrationDate: LocalDateTime,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: Set<@JvmSuppressWildcards UserRole>,

        @JsonManagedReference
        @OneToOne
        var person: Person?

) {

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (password != other.password) return false
        if (registrationDate != other.registrationDate) return false
        if (roles != other.roles) return false
        if (person != other.person) return false

        return true
    }

    override fun hashCode(): Int{
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + registrationDate.hashCode()
        result = 31 * result + roles.hashCode()
        result = 31 * result + (person?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String{
        return "User(id=$id, name='$name', password='$password', registrationDate=$registrationDate, roles=$roles, person=$person)"
    }


    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    private constructor() : this(
            name = "",
            password = "",
            registrationDate = LocalDateTime.now(),
            roles = HashSet(),
            person = null
    )

}