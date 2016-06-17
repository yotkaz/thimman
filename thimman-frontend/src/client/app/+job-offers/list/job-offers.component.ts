import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { JobOffer } from '../job-offer';
import { JobOffersService } from '../job-offers.service';
import { SearchPipe } from "../../shared/pipes/search.pipe";

@Component({
    selector: 'sd-home',
    templateUrl: 'app/+job-offers/list/job-offers.component.html',
    styleUrls: ['app/+job-offers/list/job-offers.component.css'],
    providers: [JobOffersService],
    pipes: [SearchPipe]
})
export class JobOffersComponent implements OnInit {

    jobOffers: JobOffer[];
    jobOffersSearchValue: String = "";

    error: any;

    constructor(
        private router: Router,
        private jobOfferService: JobOffersService) { }

    ngOnInit() {
        this.getJobOffers();
    }

    getJobOffers() {
        this.jobOfferService
            .getJobOffers()
            .then(jobOffers => this.jobOffers = jobOffers)
            .catch(error => this.error = error); // TODO: Display error message
    }

    gotoNewJobOffer() {
        this.router.navigate(['/job-offers/new']);
    }
}