package yotkaz.thimman.backend.service

import org.springframework.stereotype.Service

interface ICRUDService<EntityType, IdType> {

    fun getAll(): List<EntityType>;

    fun getOne(id: IdType): EntityType;

    fun save(entity: EntityType): EntityType;

    fun delete(entity: EntityType);

}