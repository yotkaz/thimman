package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Project
import yotkaz.thimman.backend.service.impl.ProjectService

@RestController
@RequestMapping("/projects")
class ProjectController : AbstractCRUDController<Project, Long, ProjectService>()