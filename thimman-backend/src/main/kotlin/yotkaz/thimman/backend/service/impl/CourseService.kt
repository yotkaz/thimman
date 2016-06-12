package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Course
import yotkaz.thimman.backend.repository.CourseRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class CourseService : AbstractCRUDService<Course, Long, CourseRepository>() {

    override fun checkSaveConstraints(entity: Course) {
        // nothing to do here
    }

}