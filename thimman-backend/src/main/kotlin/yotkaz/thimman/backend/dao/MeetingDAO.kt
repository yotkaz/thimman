package yotkaz.thimman.backend.dao

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Meeting
import javax.transaction.Transactional

/**
 * Created on 22.04.16.
 */
@Transactional
interface MeetingDAO : CrudRepository<Meeting, Long> {

}