package yotkaz.thimman.backend.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

/**
 * Created on 22.04.16.
 */
@SpringBootApplication
@ComponentScan("yotkaz.thimman.backend")
open class Application {
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args);
}