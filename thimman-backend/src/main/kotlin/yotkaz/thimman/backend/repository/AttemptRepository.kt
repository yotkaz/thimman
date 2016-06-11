package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Attempt
import javax.transaction.Transactional

@Transactional
interface AttemptRepository : CrudRepository<Attempt, Long>