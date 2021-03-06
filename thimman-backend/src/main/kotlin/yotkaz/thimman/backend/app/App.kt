package yotkaz.thimman.backend.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("yotkaz.thimman.backend")
@EntityScan(basePackages = arrayOf("yotkaz.thimman.backend.model"))
@EnableJpaRepositories(basePackages = arrayOf("yotkaz.thimman.backend.repository"))
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args);
}