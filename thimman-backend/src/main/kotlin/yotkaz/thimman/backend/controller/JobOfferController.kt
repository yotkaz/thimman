package yotkaz.thimman.backend.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yotkaz.thimman.backend.model.JobOffer
import yotkaz.thimman.backend.service.JobOfferService

@RestController
@RequestMapping("/job-offers")
class JobOfferController : AbstractCRUDController<JobOffer, Long, JobOfferService>()