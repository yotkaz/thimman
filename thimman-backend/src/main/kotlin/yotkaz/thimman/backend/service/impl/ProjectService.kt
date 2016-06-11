package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Project
import yotkaz.thimman.backend.repository.ProjectRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class ProjectService : AbstractCRUDService<Project, Long, ProjectRepository>()