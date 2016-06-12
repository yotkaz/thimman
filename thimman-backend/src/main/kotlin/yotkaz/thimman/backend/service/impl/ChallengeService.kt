package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Challenge
import yotkaz.thimman.backend.repository.ChallengeRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class ChallengeService : AbstractCRUDService<Challenge, Long, ChallengeRepository>() {

    override fun checkSaveConstraints(entity: Challenge) {
        // nothing to do here
    }

}