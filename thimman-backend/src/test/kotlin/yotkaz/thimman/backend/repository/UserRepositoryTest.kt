package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.User
import yotkaz.thimman.backend.model.UserRole
import java.time.LocalDateTime

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class UserRepositoryTest : CRUDTest<User, Long, UserRepository>() {

    val PASSWORD_A: String = "a";
    val PASSWORD_B: String = "b";

    override fun buildObject(): User {
        return User(
                name = "User",
                password = PASSWORD_A,
                registrationDate = LocalDateTime.now(),
                roles = setOf(UserRole.BOSS),
                person = null
        );
    }

    override fun getObjectId(obj: User): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: User): User {
        obj.password = PASSWORD_B;
        return obj;
    }

    override fun isRead(obj: User): Boolean {
        return obj.password == PASSWORD_A;
    }

    override fun isUpdated(obj: User): Boolean {
        return obj.password == PASSWORD_B;
    }


}