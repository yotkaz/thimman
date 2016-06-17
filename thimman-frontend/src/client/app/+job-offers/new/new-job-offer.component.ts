import { Component, } from '@angular/core';
import { Router, ROUTER_DIRECTIVES} from '@angular/router';
import { JobOffersService } from '../job-offers.service';
import {NewJobOfferService} from "./new-job-offer.service";

@Component({
    selector: 'sd-home',
    templateUrl: 'app/+job-offers/new/new-job-offer.component.html',
    styleUrls: ['app/+job-offers/new/new-job-offer.component.css'],
    providers: [JobOffersService, NewJobOfferService],
    directives: [ROUTER_DIRECTIVES]
})
export class NewJobOfferComponent {

    error: any;

    constructor(
        private router: Router,
        private jobOfferService: JobOffersService
    ) { }

}