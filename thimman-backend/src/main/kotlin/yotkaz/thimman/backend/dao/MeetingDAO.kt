package yotkaz.thimman.backend.dao

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.base.Meeting
import javax.transaction.Transactional

@Transactional
interface MeetingDAO : CrudRepository<Meeting, Long>