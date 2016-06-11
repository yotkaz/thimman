package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Attempt
import yotkaz.thimman.backend.repository.AttemptRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class AttemptService : AbstractCRUDService<Attempt, Long, AttemptRepository>()