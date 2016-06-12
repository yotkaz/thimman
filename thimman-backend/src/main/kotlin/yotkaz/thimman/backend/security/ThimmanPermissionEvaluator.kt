package yotkaz.thimman.backend.security

import org.springframework.security.access.AuthorizationServiceException
import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.*
import yotkaz.thimman.backend.model.UserRole.*
import java.io.Serializable

@Service
class ThimmanPermissionEvaluator : PermissionEvaluator {

    override fun hasPermission(authentication: Authentication?, targetDomainObject: Any?, permission: Any?): Boolean {
        checkTypes(authentication, permission);

        val userDetails = authentication?.principal as ThimmanUserDetails;
        if (userDetails.user.roles.contains(DEV)) {
            return true;
        } else {
            userDetails.user.person ?: throw IllegalStateException("This user isn't dev user and doesn't have assigned person" +
                    " - username: ${userDetails.username}");
        }

        return when (permission) {
            "getOne" -> hasGetOnePermission(userDetails, targetDomainObject)
            "getAll" -> true // to filter
            "save" -> hasSavePermission(userDetails, targetDomainObject)
            "delete" -> hasDeletePermission(userDetails, targetDomainObject)
            else -> false;
        }
    }

    override fun hasPermission(authentication: Authentication?, targetId: Serializable?, targetType: String?, permission: Any?): Boolean {
        throw UnsupportedOperationException("Id and Class permissions are not supported by " + this.javaClass.toString());
    }

    private fun hasGetOnePermission(userDetails: ThimmanUserDetails, targetDomainObject: Any?) : Boolean {
        val user = userDetails.user;
        val person = user.person!!;
        return when (targetDomainObject) {
            is Attempt -> hasAnyRole(userDetails, BOSS, EMPLOYEE) or (targetDomainObject.person == person)
            is Challenge -> {
                hasAnyRole(userDetails, BOSS, EMPLOYEE) or isAnyJobOfferContainsChallenge(
                        person.jobOffers, targetDomainObject);
            }
            is Course -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is JobOffer -> true
            is Lesson -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Material -> {
                hasAnyRole(userDetails, BOSS, EMPLOYEE) or isAnyJobOfferContainsMaterial(
                        person.jobOffers, targetDomainObject);
            }
            is Meeting -> {
                hasAnyRole(userDetails, BOSS, EMPLOYEE) or targetDomainObject.persons.contains(person);
            }
            is Person -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Project -> {
                hasAnyRole(userDetails, BOSS, EMPLOYEE) or isAnyJobOfferContainsProject(
                        person.jobOffers, targetDomainObject);
            }
            is Skill -> true
            is User -> hasAnyRole(userDetails, BOSS) or (targetDomainObject == user)
            else -> false
        }
    }

    private fun hasSavePermission(userDetails: ThimmanUserDetails, targetDomainObject: Any?) : Boolean {
        val user = userDetails.user;
        val person = user.person!!;
        return when (targetDomainObject) {
            is Attempt -> {
                if (targetDomainObject.id != null) canUpdateAttempt(person, targetDomainObject)
                else canCreateAttempt(person, targetDomainObject)
            }
            is Challenge -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Course -> hasAnyRole(userDetails, BOSS)
            is JobOffer -> hasAnyRole(userDetails, BOSS)
            is Lesson -> hasAnyRole(userDetails, BOSS)
            is Material -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Meeting -> hasAnyRole(userDetails, BOSS) or (targetDomainObject.initiator == person)
            is Person -> hasAnyRole(userDetails, BOSS)
            is Project -> hasAnyRole(userDetails, BOSS)
            is Skill -> hasAnyRole(userDetails, BOSS)
            is User -> hasAnyRole(userDetails, BOSS) or (targetDomainObject.id == null) or (targetDomainObject == user)
            else -> false
        }
    }

    private fun hasDeletePermission(userDetails: ThimmanUserDetails, targetDomainObject: Any?) : Boolean {
        val user = userDetails.user;
        val person = user.person!!;
        return when (targetDomainObject) {
            is Attempt -> hasAnyRole(userDetails, BOSS)
            is Challenge -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Course -> hasAnyRole(userDetails, BOSS)
            is JobOffer -> hasAnyRole(userDetails, BOSS)
            is Lesson -> hasAnyRole(userDetails, BOSS)
            is Material -> hasAnyRole(userDetails, BOSS, EMPLOYEE)
            is Meeting -> hasAnyRole(userDetails, BOSS) or (targetDomainObject.initiator == person)
            is Person -> hasAnyRole(userDetails, BOSS)
            is Project -> hasAnyRole(userDetails, BOSS)
            is Skill -> hasAnyRole(userDetails, BOSS)
            is User -> hasAnyRole(userDetails, BOSS) or (targetDomainObject == user)
            else -> false
        }
    }

    private fun hasAnyRole(userDetails: ThimmanUserDetails, vararg roles: UserRole) : Boolean {
        return roles.any {
            role -> userDetails.user.roles.contains(role);
        }
    }

    private fun checkTypes(authentication: Authentication?, permission: Any?) {
        if (authentication?.principal !is ThimmanUserDetails) {
            throw AuthorizationServiceException("User cannot be authorized");
        }
        if (permission !is String) {
            throw AuthorizationServiceException("User cannot be authorized");
        }
    }

    private fun isAnyJobOfferContainsChallenge(jobOffers: Collection<JobOffer>, challenge: Challenge) : Boolean {
        return jobOffers.any {
            jobOffer -> jobOffer.challenges.any {
                jobOfferChallenge -> jobOfferChallenge.challenge == challenge;
            }
        }
    }

    private fun isAnyJobOfferContainsMaterial(jobOffers: Collection<JobOffer>, material: Material) : Boolean {
        return jobOffers.any {
            jobOffer -> jobOffer.materials.contains(material);
        }
    }

    private fun isAnyJobOfferContainsProject(jobOffers: Collection<JobOffer>, project: Project) : Boolean {
        return jobOffers.any {
            jobOffer -> jobOffer.projects.contains(project);
        }
    }

    private fun canCreateAttempt(person: Person, attempt: Attempt) : Boolean {
        val isInCourses = person.courses.any {
            course -> course.lessons.any {
                lesson -> lesson.challenges.any {
                    lessonChallenge -> lessonChallenge.challenge == attempt.challenge;
                }
            }
        }
        val isInJobOffers = person.jobOffers.any {
            jobOffer -> jobOffer.challenges.any {
                jobOfferChallenge -> jobOfferChallenge.challenge == attempt.challenge;
            }
        }
        return isInCourses or isInJobOffers;
    }

    private fun canUpdateAttempt(person: Person, attempt: Attempt) : Boolean {
        return person.challengesAvailableToRate.any {
            challenge -> challenge == attempt.challenge;
        }
    }

}