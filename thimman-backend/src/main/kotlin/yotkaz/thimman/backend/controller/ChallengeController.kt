package yotkaz.thimman.backend.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Challenge
import yotkaz.thimman.backend.model.ChallengeType
import yotkaz.thimman.backend.security.CRUDLogType
import yotkaz.thimman.backend.security.ThimmanUserDetails
import yotkaz.thimman.backend.service.impl.ChallengeService

@RestController
@RequestMapping("/challenges")
class ChallengeController : AbstractCRUDController<Challenge, Long, ChallengeService>() {

    @RequestMapping("/tests", method = arrayOf(RequestMethod.GET))
    fun readTests(@AuthenticationPrincipal userDetails: ThimmanUserDetails): List<Challenge> {
        crudLog(userDetails, CRUDLogType.READ_ALL, "tests")
        return service.getByType(ChallengeType.TEST);
    }

    @RequestMapping("/tasks", method = arrayOf(RequestMethod.GET))
    fun readTasks(@AuthenticationPrincipal userDetails: ThimmanUserDetails): List<Challenge> {
        crudLog(userDetails, CRUDLogType.READ_ALL, "taks")
        return service.getByType(ChallengeType.TASK);
    }

}