package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Meeting
import yotkaz.thimman.backend.repository.MeetingRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class MeetingService : AbstractCRUDService<Meeting, Long, MeetingRepository>()