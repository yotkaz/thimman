package yotkaz.thimman.backend.repository

import org.springframework.data.repository.CrudRepository
import yotkaz.thimman.backend.model.JobOffer
import javax.transaction.Transactional

@Transactional
interface JobOfferRepository : CrudRepository<JobOffer, Long>