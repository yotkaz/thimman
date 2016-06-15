package yotkaz.thimman.backend.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.User
import yotkaz.thimman.backend.repository.UserRepository

@Service
class ThimmanUserDetailsService : UserDetailsService {

    lateinit var userRepository: UserRepository;

    @Autowired
    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository;
    }

    override fun loadUserByUsername(username: String?): UserDetails? {
        val user: User? = userRepository.findByName(username);
        user?.let {
            return ThimmanUserDetails(user);
        }
        throw UsernameNotFoundException("No user present with username: " + username);
    }

}