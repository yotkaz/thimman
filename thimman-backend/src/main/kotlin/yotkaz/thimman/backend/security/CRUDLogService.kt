package yotkaz.thimman.backend.security

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CRUDLogService {

    private val log: Log = LogFactory.getLog(this.javaClass);

    @Value("\${thimman.log.crud.create:true}")
    private var createLog = true;

    @Value("\${thimman.log.crud.readAll:true}")
    private var readAllLog = true;

    @Value("\${thimman.log.crud.read:true}")
    private var readLog = true;

    @Value("\${thimman.log.crud.update:true}")
    private var updateLog = true;

    @Value("\${thimman.log.crud.delete:true}")
    private var deleteLog = true;

    @Value("\${thimman.log.crud.another:true}")
    private var anotherLog = true;

    fun crudLog(userDetails: ThimmanUserDetails, controller: String, action: CRUDLogType, info: String = "") {
        val logBoolean: Boolean = when(action) {
            CRUDLogType.CREATE -> createLog
            CRUDLogType.READ -> readLog
            CRUDLogType.READ_ALL -> readAllLog
            CRUDLogType.UPDATE -> updateLog
            CRUDLogType.DELETE -> deleteLog
            CRUDLogType.ANOTHER -> anotherLog
        }
        if (logBoolean) {
            log.info(
                    """
                    |CRUD Action
                    |User: ${userDetails.username}
                    |Controller: $controller
                    |Action: $action
                    |Info: $info
                    """.trimMargin()
            );
        }
    }

}