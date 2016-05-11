package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Meeting
import javax.transaction.Transactional

@Transactional
interface MeetingRepository : CrudRepository<Meeting, Long>