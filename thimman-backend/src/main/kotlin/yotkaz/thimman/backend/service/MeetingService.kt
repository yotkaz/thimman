package yotkaz.thimman.backend.service

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Meeting
import yotkaz.thimman.backend.repository.MeetingRepository

@Service
class MeetingService : AbstractCRUDService<Meeting, Long, MeetingRepository>()