package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Lesson
import yotkaz.thimman.backend.service.impl.LessonService

@RestController
@RequestMapping("/lessons")
class LessonController : AbstractCRUDController<Lesson, Long, LessonService>()