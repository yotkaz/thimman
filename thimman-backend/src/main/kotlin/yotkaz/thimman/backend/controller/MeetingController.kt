package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Meeting
import yotkaz.thimman.backend.service.impl.MeetingService

@RestController
@RequestMapping("/meetings")
class MeetingController : AbstractCRUDController<Meeting, Long, MeetingService>()