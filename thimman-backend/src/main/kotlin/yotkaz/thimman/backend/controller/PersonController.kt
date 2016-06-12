package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Person
import yotkaz.thimman.backend.service.impl.PersonService

@RestController
@RequestMapping("/persons")
class PersonController : AbstractCRUDController<Person, Long, PersonService>()