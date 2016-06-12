package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Material
import yotkaz.thimman.backend.repository.MaterialRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class MaterialService : AbstractCRUDService<Material, Long, MaterialRepository>() {

    override fun checkSaveConstraints(entity: Material) {
        // nothing to do here
    }

}