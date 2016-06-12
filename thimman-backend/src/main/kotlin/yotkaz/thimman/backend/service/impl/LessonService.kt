package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Lesson
import yotkaz.thimman.backend.repository.LessonRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class LessonService : AbstractCRUDService<Lesson, Long, LessonRepository>() {

    override fun checkSaveConstraints(entity: Lesson) {
        // nothing to do here
    }

}