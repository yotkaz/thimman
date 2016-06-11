package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.ChallangeType
import yotkaz.thimman.backend.model.Challenge

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class ChallengeRepositoryTest : CRUDTest<Challenge, Long, ChallengeRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Challenge {
        return Challenge(
                name = "Challenge",
                description = DESC_A,
                type = ChallangeType.TASK
        );
    }

    override fun getObjectId(obj: Challenge): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Challenge): Challenge {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Challenge): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Challenge): Boolean {
        return obj.description == DESC_B;
    }


}