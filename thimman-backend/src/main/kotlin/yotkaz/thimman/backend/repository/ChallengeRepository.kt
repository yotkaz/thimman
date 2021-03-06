package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Challenge
import yotkaz.thimman.backend.model.ChallengeType
import javax.transaction.Transactional

@Transactional
interface ChallengeRepository : CrudRepository<Challenge, Long> {

    @Transactional
    fun findByType(type: ChallengeType) : List<Challenge>;

}