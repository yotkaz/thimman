package yotkaz.thimman.backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import yotkaz.thimman.backend.service.ICRUDService
import java.io.Serializable

abstract class AbstractCRUDController<ObjectType, IdType, ServiceType>
    where ServiceType : ICRUDService<ObjectType, IdType>, IdType : Serializable {

    @Autowired
    private lateinit var service: ServiceType;

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(obj: ObjectType) = service.save(obj);

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun readAll(): List<ObjectType> = service.getAll();

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun readOne(@PathVariable id: IdType): ObjectType = service.getOne(id);

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(obj: ObjectType) = service.save(obj);

    @RequestMapping("/delete", method = arrayOf(RequestMethod.DELETE))
    fun delete(obj: ObjectType) = service.delete(obj);
}