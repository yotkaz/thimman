package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Material
import javax.transaction.Transactional

@Transactional
interface MaterialRepository : CrudRepository<Material, Long>