package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Lesson
import javax.transaction.Transactional

@Transactional
interface LessonRepository : CrudRepository<Lesson, Long>