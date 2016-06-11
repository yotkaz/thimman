package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Project

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class ProjectRepositoryTest : CRUDTest<Project, Long, ProjectRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Project {
        return Project(
                name = "Project",
                description = DESC_A
        );
    }

    override fun getObjectId(obj: Project): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Project): Project {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Project): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Project): Boolean {
        return obj.description == DESC_B;
    }


}