package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.Person
import yotkaz.thimman.backend.model.PersonType
import yotkaz.thimman.backend.repository.PersonRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class PersonService : AbstractCRUDService<Person, Long, PersonRepository>() {

    override fun checkSaveConstraints(entity: Person) {
        if (entity.types.isEmpty()) {
            throw IllegalArgumentException("At least one type must be assigned to person; $entity");
        }
        if ((!entity.types.contains(PersonType.EMPLOYEE)) and (entity.employmentDate != null)) {
            throw IllegalArgumentException("Only employees can have employment date; $entity");
        }
        if ((!entity.types.contains(PersonType.CANDIDATE)) and (entity.cv != null)) {
            throw IllegalArgumentException("Only candidates can have cv; $entity");
        }
    }

}