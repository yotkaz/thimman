package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/user")
class UserController {

    @RequestMapping("/echo")
    fun user(user: Principal): Principal = user;

}