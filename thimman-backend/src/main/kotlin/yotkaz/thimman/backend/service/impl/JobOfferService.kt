package yotkaz.thimman.backend.service.impl

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.JobOffer
import yotkaz.thimman.backend.repository.JobOfferRepository
import yotkaz.thimman.backend.service.AbstractCRUDService

@Service
class JobOfferService : AbstractCRUDService<JobOffer, Long, JobOfferRepository>() {

    override fun checkSaveConstraints(entity: JobOffer) {
        // nothing to do here
    }

}