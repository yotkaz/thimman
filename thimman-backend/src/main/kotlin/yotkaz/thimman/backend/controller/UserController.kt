package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController {

    @RequestMapping("/user")
    fun user(user: Principal): Principal {
        return user;
    }

}