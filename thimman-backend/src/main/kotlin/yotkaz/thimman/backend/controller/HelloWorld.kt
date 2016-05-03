package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @RequestMapping("/hello")
    fun sayHello(): String = "Hello World!";

}