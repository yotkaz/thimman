package yotkaz.thimman.backend.service

import org.springframework.stereotype.Service
import yotkaz.thimman.backend.model.JobOffer
import yotkaz.thimman.backend.repository.JobOfferRepository

@Service
class JobOfferService : AbstractCRUDService<JobOffer, Long, JobOfferRepository>()