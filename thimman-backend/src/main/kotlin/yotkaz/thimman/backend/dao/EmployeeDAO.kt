package yotkaz.thimman.backend.dao

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.Employee
import javax.transaction.Transactional

/**
 * Created on 22.04.16.
 */
@Transactional
interface EmployeeDAO : CrudRepository<Employee, Long> {

}