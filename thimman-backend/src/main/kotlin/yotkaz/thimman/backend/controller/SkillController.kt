package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Skill
import yotkaz.thimman.backend.service.impl.SkillService

@RestController
@RequestMapping("/skills")
class SkillController : AbstractCRUDController<Skill, Long, SkillService>()