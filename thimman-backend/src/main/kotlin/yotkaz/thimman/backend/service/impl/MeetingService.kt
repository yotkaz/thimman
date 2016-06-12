package yotkaz.thimman.backend.service.impl

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Meeting
import yotkaz.thimman.backend.model.PersonType
import yotkaz.thimman.backend.repository.MeetingRepository
import yotkaz.thimman.backend.service.AbstractCRUDService
import java.time.temporal.ChronoUnit

@Service
class MeetingService : AbstractCRUDService<Meeting, Long, MeetingRepository>() {

    @Value("\${thimman.meeting.maxLength:8}")
    private var maxLengthHours = 8;

    override fun checkSaveConstraints(entity: Meeting) {
        entity.initiator ?: throw IllegalArgumentException("Meeting initiator cannot be null; $entity");
        if (entity.initiator!!.types.contains(PersonType.EMPLOYEE)) {
            throw IllegalArgumentException("Meeting initiator must be an employee; $entity");
        }
        if (entity.persons.isEmpty()) {
            throw IllegalArgumentException("At least one person must be invited to the meeting; $entity");
        }
        val meetingLengthHours = ChronoUnit.HOURS.between(entity.startTime, entity.endTime);
        if (meetingLengthHours < 0) {
            throw IllegalArgumentException("Meeting end time cannot be before start time; $entity");
        }
        if (meetingLengthHours > maxLengthHours) {
            throw IllegalArgumentException("Too long meeting. Max length is $maxLengthHours hours; $entity");
        }
    }

}