package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Skill
import yotkaz.thimman.backend.repository.SkillRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class SkillService : AbstractCRUDService<Skill, Long, SkillRepository>()