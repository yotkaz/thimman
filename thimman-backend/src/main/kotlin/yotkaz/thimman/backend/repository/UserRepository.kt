package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.User
import javax.transaction.Transactional

@Transactional
interface UserRepository : CrudRepository<User, Long> {

    fun findByName(name: String?) : User;

}