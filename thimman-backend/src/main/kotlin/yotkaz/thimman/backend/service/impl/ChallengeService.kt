package yotkaz.thimman.backend.service.impl

import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Challenge
import yotkaz.thimman.backend.model.ChallengeType
import yotkaz.thimman.backend.repository.ChallengeRepository
import yotkaz.thimman.backend.service.AbstractCRUDService
import java.util.*

@Service
class ChallengeService : AbstractCRUDService<Challenge, Long, ChallengeRepository>() {

    @PreAuthorize("hasPermission('getAll')")
    @PostFilter("hasPermission(filterObject, 'getOne')")
    fun getByType(type: ChallengeType) : List<Challenge> {
        with(ArrayList<Challenge>()) {
            addAll(dao.findByType(type));
            return this;
        }
    }

    override fun checkSaveConstraints(entity: Challenge) {
        // nothing to do here
    }

}