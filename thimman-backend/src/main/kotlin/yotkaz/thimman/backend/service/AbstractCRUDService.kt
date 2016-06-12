package yotkaz.thimman.backend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.security.access.prepost.PostFilter
import org.springframework.security.access.prepost.PreAuthorize
import java.io.Serializable
import java.util.*

abstract class AbstractCRUDService<EntityType, IdType, DAOType> : ICRUDService<EntityType, IdType>
    where DAOType : CrudRepository<EntityType, IdType>, IdType : Serializable{

    @Autowired
    protected lateinit var dao: DAOType;

    @PreAuthorize("hasPermission('getAll')")
    @PostFilter("hasPermission(filterObject, 'getOne')")
    override fun getAll(): List<EntityType> {
        with(ArrayList<EntityType>()) {
            addAll(dao.findAll());
            return this;
        }
    }

    @PreAuthorize("hasPermission(returnObject, 'getOne')")
    override fun getOne(id: IdType): EntityType = dao.findOne(id);

    @PreAuthorize("hasPermission(#entity, 'save')")
    override fun save(entity: EntityType) : EntityType {
        checkSaveConstraints(entity);
        return dao.save(entity);
    };

    @PreAuthorize("hasPermission(#entity, 'delete')")
    override fun delete(entity: EntityType) = dao.delete(entity);

    abstract fun checkSaveConstraints(entity: EntityType);

}