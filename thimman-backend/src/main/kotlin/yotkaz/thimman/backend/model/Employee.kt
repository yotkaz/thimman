package yotkaz.thimman.backend.model

import java.util.*

/**
 * Created on 22.04.16.
 */
class Employee(id: Int?, firstName: String, lastName: String, var employmentDate: Date) : Person(id, firstName, lastName)