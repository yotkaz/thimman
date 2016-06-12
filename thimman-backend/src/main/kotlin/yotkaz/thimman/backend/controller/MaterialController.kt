package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.Material
import yotkaz.thimman.backend.service.impl.MaterialService

@RestController
@RequestMapping("/materials")
class MaterialController : AbstractCRUDController<Material, Long, MaterialService>()