package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.Address
import yotkaz.thimman.backend.model.Person
import yotkaz.thimman.backend.model.PersonType
import java.time.LocalDateTime
import java.util.*

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class PersonRepositoryTest : CRUDTest<Person, Long, PersonRepository>() {

    val EMAIL_A: String = "a@example.com";
    val EMAIL_B: String = "b@example.com";

    val BUILDING_A: String = "69A";
    val BUILDING_B: String = "69B";

    override fun buildObject(): Person {
        return Person(
                firstName = "Person",
                lastName = "",
                contactAddress = Address(
                        country = "Poland",
                        city = "Warsaw",
                        street = "Golden",
                        buildingNumber = BUILDING_A,
                        apartmentNumber = "69",
                        postalCode = "00-000"
                ),
                email = EMAIL_A,
                types = setOf(PersonType.EMPLOYEE),
                employmentDate = LocalDateTime.now(),
                declaredSkills = ArrayList()
        );
    }

    override fun getObjectId(obj: Person): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: Person): Person {
        obj.email = EMAIL_B;
        obj.contactAddress!!.buildingNumber = BUILDING_B;
        return obj;
    }

    override fun isRead(obj: Person): Boolean {
        val isAddress = (obj.contactAddress!!.buildingNumber == BUILDING_A);
        val isEmail = (obj.email == EMAIL_A);
        return isAddress && isEmail;
    }

    override fun isUpdated(obj: Person): Boolean {
        val isAddress = (obj.contactAddress!!.buildingNumber == BUILDING_B);
        val isEmail = (obj.email == EMAIL_B);
        return isAddress && isEmail;
    }


}