package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Course
import yotkaz.thimman.backend.service.impl.CourseService

@RestController
@RequestMapping("/courses")
class CourseController : AbstractCRUDController<Course, Long, CourseService>()