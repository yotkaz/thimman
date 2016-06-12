package yotkaz.thimman.backend.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import yotkaz.thimman.backend.model.User
import java.util.*

open class ThimmanUserDetails (

        var user: User

) : UserDetails {

    override fun getUsername(): String? = user.name

    override fun getPassword(): String? = user.password

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isEnabled(): Boolean = true

    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return ArrayList(
                user.roles.map {
                    role -> SimpleGrantedAuthority(role.name)
                }
        );
    }

}