package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Challenge
import yotkaz.thimman.backend.service.impl.ChallengeService

@RestController
@RequestMapping("/challenges")
class ChallengeController : AbstractCRUDController<Challenge, Long, ChallengeService>()