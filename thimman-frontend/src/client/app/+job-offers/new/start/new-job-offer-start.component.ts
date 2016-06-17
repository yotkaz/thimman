import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import {JobOffer} from "../../job-offer";
import {JobOffersService} from "../../job-offers.service";
import {NewJobOfferService} from "../new-job-offer.service";
import {Project} from "../../project";
import {Skill} from "../../skill";

@Component({
    templateUrl: 'app/+job-offers/new/start/new-job-offer-start.component.html',
    styleUrls: ['app/+job-offers/new/start/new-job-offer-start.component.css'],
    providers: [JobOffersService]
})
export class NewJobOfferStartComponent implements OnInit  {

    error: any;

    jobOffer: JobOffer = new JobOffer();

    projects: Project[];


    constructor(
        private router: Router,
        private jobOfferService: JobOffersService,
        private newJobOfferService: NewJobOfferService
    ) { }

    ngOnInit() {
        this.jobOffer = new JobOffer();
        this.jobOffer.status = 'AVAILABLE';
    }

    getProjects() {
        this.jobOfferService
            .getProjects()
            .then(projects => this.projects = projects)
            .catch(error => this.error = error); // TODO: Display error message
    }

    next() {
        this.newJobOfferService.jobOffer = this.jobOffer;
        this.router.navigate(['/job-offers/new/skills']);
    }

    cancel() {
        this.newJobOfferService.jobOffer = new JobOffer();
        this.router.navigate(['/job-offers']);
    }


}