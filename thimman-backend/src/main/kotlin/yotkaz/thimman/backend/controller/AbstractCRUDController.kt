package yotkaz.thimman.backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import yotkaz.thimman.backend.security.CRUDLogService
import yotkaz.thimman.backend.security.CRUDLogType
import yotkaz.thimman.backend.security.ThimmanUserDetails
import yotkaz.thimman.backend.service.ICRUDService
import java.io.Serializable

abstract class AbstractCRUDController<ObjectType, IdType, ServiceType>
    where ServiceType : ICRUDService<ObjectType, IdType>, IdType : Serializable {

    @Autowired
    protected lateinit var crudLogService: CRUDLogService;

    @Autowired
    protected lateinit var service: ServiceType;

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(obj: ObjectType, @AuthenticationPrincipal userDetails: ThimmanUserDetails) {
        crudLog(userDetails, CRUDLogType.CREATE, obj.toString())
        service.save(obj);
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun readAll(@AuthenticationPrincipal userDetails: ThimmanUserDetails): List<ObjectType> {
        crudLog(userDetails, CRUDLogType.READ_ALL)
        return service.getAll()
    }

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.GET))
    fun read(@PathVariable id: IdType, @AuthenticationPrincipal userDetails: ThimmanUserDetails): ObjectType {
        crudLog(userDetails, CRUDLogType.READ, id.toString())
        return service.getOne(id)
    }

    @RequestMapping("/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(obj: ObjectType, @AuthenticationPrincipal userDetails: ThimmanUserDetails) {
        crudLog(userDetails, CRUDLogType.UPDATE, obj.toString())
        service.save(obj)
    }

    @RequestMapping("/delete", method = arrayOf(RequestMethod.DELETE))
    fun delete(obj: ObjectType, @AuthenticationPrincipal userDetails: ThimmanUserDetails) {
        crudLog(userDetails, CRUDLogType.DELETE, obj.toString())
        service.delete(obj)
    }

    @RequestMapping("/delete/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: IdType, @AuthenticationPrincipal userDetails: ThimmanUserDetails) {
        crudLog(userDetails, CRUDLogType.DELETE, id.toString())
        service.delete(service.getOne(id));
    }

    protected fun crudLog(@AuthenticationPrincipal userDetails: ThimmanUserDetails,
                        action: CRUDLogType,
                        info: String = "") {
        crudLogService.crudLog(userDetails, this.javaClass.simpleName, action, info)
    }

}