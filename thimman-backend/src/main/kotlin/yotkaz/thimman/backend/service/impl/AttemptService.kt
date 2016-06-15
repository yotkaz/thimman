package yotkaz.thimman.backend.service.impl

import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Attempt
import yotkaz.thimman.backend.repository.AttemptRepository
import yotkaz.thimman.backend.service.AbstractCRUDService
import java.util.*

@Service
class AttemptService : AbstractCRUDService<Attempt, Long, AttemptRepository>() {

    @PreAuthorize("hasPermission('getAll')")
    @PostFilter("hasPermission(filterObject, 'getOne')")
    fun getNotRated() : List<Attempt> {
        with(ArrayList<Attempt>()) {
            addAll(dao.findByRatedTrue());
            return this;
        }
    }

    override fun checkSaveConstraints(entity: Attempt) {
        entity.person ?: throw IllegalArgumentException("There must be a person assigned to the attempt; $entity");
        entity.challenge ?: throw IllegalArgumentException("There must be a challenge assigned to the attempt; $entity");
        entity.id ?: checkCreateConstraints(entity);
        checkScore(entity);
        checkMaxAttemptsCount(entity);
    }

    private fun checkCreateConstraints(attempt: Attempt) {
        if (attempt.rated or (attempt.employeeWhichRated != null) or (attempt.score != null)) {
            throw IllegalArgumentException("Illegal attempt: $attempt");
        }
    }

    private fun checkMaxAttemptsCount(attempt: Attempt) {
        val person = attempt.person!!;
        val challenge = attempt.challenge!!;
        var attemptsCount = person.attempts.count {
            anotherAttempt -> anotherAttempt.challenge == challenge;
        }
        if (!person.attempts.contains(attempt)) {
            attemptsCount++;
        }
        val isInJobOffers = challenge.jobOfferChallenges.any {
            jobOfferChallenge -> ((jobOfferChallenge.challengeAttributes == null)
                or ((jobOfferChallenge.challengeAttributes!!.maxAttempts != null)
                    and (jobOfferChallenge.challengeAttributes!!.maxAttempts!! >= attemptsCount)));
        }
        val isInLessons = challenge.lessonChallenges.any {
            lessonChallenge -> ((lessonChallenge.challengeAttributes == null)
                or ((lessonChallenge.challengeAttributes!!.maxAttempts != null)
                    and (lessonChallenge.challengeAttributes!!.maxAttempts!! >= attemptsCount)));
        }
        if (isInJobOffers or isInLessons) {
            return;
        }
        throw IllegalArgumentException("Max attempts count reached; $attempt");
    }

    private fun checkScore(attempt: Attempt) {
        attempt.score?.let {
            if ((attempt.score!! < 0.0) or (attempt.score!! > 100.0)) {
                throw IllegalArgumentException("Score must be a double between 0 and 100; $attempt");
            }
        }
    }

}