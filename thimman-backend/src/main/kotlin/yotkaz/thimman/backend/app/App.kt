package yotkaz.thimman.backend.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import yotkaz.thimman.backend.dao.EmployeeDAO
import yotkaz.thimman.backend.model.Employee
import java.util.*
import javax.annotation.PostConstruct

/**
 * Created on 22.04.16.
 */
@SpringBootApplication
@ComponentScan("yotkaz.thimman.backend")
@EntityScan(basePackages = arrayOf("yotkaz.thimman.backend.model"))
@EnableJpaRepositories(basePackages = arrayOf("yotkaz.thimman.backend.dao"))
open class Application {

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args);
}