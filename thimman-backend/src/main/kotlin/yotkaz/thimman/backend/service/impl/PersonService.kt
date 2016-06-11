package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Person
import yotkaz.thimman.backend.repository.PersonRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class PersonService : AbstractCRUDService<Person, Long, PersonRepository>()