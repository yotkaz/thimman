package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Course
import javax.transaction.Transactional

@Transactional
interface CourseRepository : CrudRepository<Course, Long>