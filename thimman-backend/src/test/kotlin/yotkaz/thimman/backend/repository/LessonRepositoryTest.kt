package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Lesson

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class LessonRepositoryTest : CRUDTest<Lesson, Long, LessonRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Lesson {
        return Lesson(
                name = "Lesson",
                description = DESC_A,
                course = null
        );
    }

    override fun getObjectId(obj: Lesson): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Lesson): Lesson {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Lesson): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Lesson): Boolean {
        return obj.description == DESC_B;
    }


}