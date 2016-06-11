package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Skill

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class SkillRepositoryTest : CRUDTest<Skill, Long, SkillRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Skill {
        return Skill(
                name = "Skill",
                description = DESC_A
        );
    }

    override fun getObjectId(obj: Skill): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Skill): Skill {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Skill): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Skill): Boolean {
        return obj.description == DESC_B;
    }


}