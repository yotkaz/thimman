package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Project
import javax.transaction.Transactional

@Transactional
interface ProjectRepository : CrudRepository<Project, Long>