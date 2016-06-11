package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Person
import javax.transaction.Transactional

@Transactional
interface PersonRepository : CrudRepository<Person, Long>