package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Meeting
import java.util.*

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class MeetingRepositoryTest : CRUDTest<Meeting, Long, MeetingRepository>() {

    val SUBJECT_TEST: String = "Test";
    val PLACE_BALI: String = "Bali";
    val PLACE_JAVA: String = "Java";


    override fun buildObject(): Meeting {
        return Meeting(
                subject = SUBJECT_TEST,
                place = PLACE_BALI,
                startTime = Date(),
                endTime = Date(),
                persons = HashSet(),
                initiator = null
        );
    }

    override fun getObjectId(obj: Meeting): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Meeting): Meeting {
        obj.place = PLACE_JAVA;
        return obj;
    }

    override fun isRead(obj: Meeting): Boolean {
        return obj.place == PLACE_BALI;
    }

    override fun isUpdated(obj: Meeting): Boolean {
        return obj.place == PLACE_JAVA;
    }


}