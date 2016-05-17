package yotkaz.thimman.backend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import java.io.Serializable
import java.util.*

abstract class AbstractCRUDService<EntityType, IdType, DAOType> : ICRUDService<EntityType, IdType>
    where DAOType : CrudRepository<EntityType, IdType>, IdType : Serializable{

    @Autowired
    private lateinit var dao: DAOType;

    override fun getAll(): List<EntityType> {
        with(ArrayList<EntityType>()) {
            addAll(dao.findAll());
            return this;
        }
    }

    override fun getOne(id: IdType): EntityType = dao.findOne(id);

    override fun save(entity: EntityType) = dao.save(entity);

    override fun delete(entity: EntityType) = dao.delete(entity);

}