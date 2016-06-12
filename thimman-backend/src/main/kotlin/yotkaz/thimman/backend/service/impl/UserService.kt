package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.User
import yotkaz.thimman.backend.model.UserRole
import yotkaz.thimman.backend.repository.UserRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class UserService : AbstractCRUDService<User, Long, UserRepository>() {

    override fun checkSaveConstraints(entity: User) {
        if (entity.roles.isEmpty()) {
            throw IllegalArgumentException("User must have at least one role");
        }
        if ((!entity.roles.contains(UserRole.DEV)) && (entity.person == null)) {
            throw IllegalArgumentException("User isn't dev user and doesn't have assigned person" +
                " - username: ${entity.name}");
        }
    }

}