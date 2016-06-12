package yotkaz.thimman.backend.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Attempt
import yotkaz.thimman.backend.security.CRUDLogType
import yotkaz.thimman.backend.security.ThimmanUserDetails
import yotkaz.thimman.backend.service.impl.AttemptService

@RestController
@RequestMapping("/attempts")
class AttemptController : AbstractCRUDController<Attempt, Long, AttemptService>() {

    @RequestMapping("/not-rated", method = arrayOf(RequestMethod.GET))
    fun readNotRated(@AuthenticationPrincipal userDetails: ThimmanUserDetails): List<Attempt> {
        crudLog(userDetails, CRUDLogType.READ_ALL, "not rated")
        return service.getNotRated();
    }

}