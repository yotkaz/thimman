package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.User
import yotkaz.thimman.backend.service.impl.UserService
import java.security.Principal

@RestController
@RequestMapping("/users")
class UserController : AbstractCRUDController<User, Long, UserService>(){

    @RequestMapping("/echo")
    fun user(user: Principal): Principal = user;

}