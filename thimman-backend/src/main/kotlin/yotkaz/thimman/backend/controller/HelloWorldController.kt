package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@RestController
class HelloWorldController {

    val randomGenerator: Random = Random();

    @RequestMapping("/hello")
    fun sayHello() = "Hello World!";

    @RequestMapping("/random")
    fun random() = randomGenerator.nextLong();

    @RequestMapping("/foo")
    fun foobar() = "bar";

    @RequestMapping("/time")
    fun time() = LocalDateTime.now();

}