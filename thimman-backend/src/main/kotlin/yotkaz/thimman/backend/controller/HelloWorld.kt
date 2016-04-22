package yotkaz.thimman.backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.dao.EmployeeDAO
import yotkaz.thimman.backend.model.Employee

/**
 * Created on 22.04.16.
 */
@RestController
class HelloWorld {

    @Autowired
    lateinit var eDAO: EmployeeDAO;

    @RequestMapping("/hello")
    fun sayHello(): String = "Hello World!";

}