package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Material

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class MaterialRepositoryTest : CRUDTest<Material, Long, MaterialRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): Material {
        return Material(
                name = "Material",
                description = DESC_A,
                reference = "http://example.com"
        );
    }

    override fun getObjectId(obj: Material): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Material): Material {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: Material): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: Material): Boolean {
        return obj.description == DESC_B;
    }


}