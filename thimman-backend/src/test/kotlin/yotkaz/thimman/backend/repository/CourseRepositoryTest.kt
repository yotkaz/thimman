package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Course

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class CourseRepositoryTest : CRUDTest<Course, Long, CourseRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Course {
        return Course(
                name = "Course",
                description = DESC_A
        );
    }

    override fun getObjectId(obj: Course): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Course): Course {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Course): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Course): Boolean {
        return obj.description == DESC_B;
    }


}