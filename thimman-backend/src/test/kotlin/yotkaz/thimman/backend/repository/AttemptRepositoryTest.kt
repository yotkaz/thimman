package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Attempt

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class AttemptRepositoryTest : CRUDTest<Attempt, Long, AttemptRepository>() {

    override fun buildObject(): Attempt {
        return Attempt(
                rated = false,
                score = null,
                person = null,
                challenge = null
        );
    }

    override fun getObjectId(obj: Attempt): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Attempt): Attempt {
        obj.rated = true;
        return obj;
    }

    override fun isRead(obj: Attempt): Boolean {
        return obj.rated == false;
    }

    override fun isUpdated(obj: Attempt): Boolean {
        return obj.rated == true;
    }


}