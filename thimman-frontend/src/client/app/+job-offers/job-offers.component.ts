import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobOffer } from './job-offer';
import { JobOfferService } from './job-offers.service';

@Component({
    selector: 'sd-home',
    templateUrl: 'app/+job-offers/job-offers.component.html',
    styleUrls: ['app/+job-offers/job-offers.component.css']
})
export class JobOffersComponent implements OnInit {

    jobOffers: JobOffer[];

    error: any;

    constructor(
        private router: Router,
        private jobOfferService: JobOfferService) { }

    getJobOffers() {
        this.jobOfferService
            .getJobOffers()
            .then(jobOffers => this.jobOffers = jobOffers)
            .catch(error => this.error = error); // TODO: Display error message
    }
    ngOnInit() {
        this.getJobOffers();
    }
}