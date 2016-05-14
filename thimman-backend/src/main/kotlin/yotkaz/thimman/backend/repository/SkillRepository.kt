package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Skill
import javax.transaction.Transactional

@Transactional
interface SkillRepository : CrudRepository<Skill, Long>