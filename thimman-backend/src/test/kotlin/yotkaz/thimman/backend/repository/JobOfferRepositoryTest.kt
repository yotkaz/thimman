package yotkaz.thimman.backend.repository

import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import yotkaz.thimman.backend.app.Application
import yotkaz.thimman.backend.model.JobOffer
import yotkaz.thimman.backend.model.JobOfferStatus
import java.util.*

@SpringApplicationConfiguration(Application::class)
@RunWith(SpringJUnit4ClassRunner::class)
class JobOfferRepositoryTest : CRUDTest<JobOffer, Long, JobOfferRepository>() {

    val DESC_A: String = "a";
    val DESC_B: String = "b";

    override fun buildObject(): JobOffer {
        return JobOffer(
                name = "JobOffer",
                description = DESC_A,
                status = JobOfferStatus.AVAILABLE,
                requiredSkills = ArrayList(),
                project = null
        );
    }

    override fun getObjectId(obj: JobOffer): Long {
        return obj.id!!;
    }

    override fun modifyObject(obj: JobOffer): JobOffer {
        obj.description = DESC_B;
        return obj;
    }

    override fun isRead(obj: JobOffer): Boolean {
        return obj.description == DESC_A;
    }

    override fun isUpdated(obj: JobOffer): Boolean {
        return obj.description == DESC_B;
    }


}