import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import {JobOffersService} from "../../job-offers.service";
import {NewJobOfferService} from "../new-job-offer.service";
import {Skill} from "../../skill";
import 'rxjs/add/operator/toPromise';

@Component({
    templateUrl: 'app/+job-offers/new/new-skill/new-job-offer-new-skill.component.html',
    styleUrls: ['app/+job-offers/new/new-skill/new-job-offer-new-skill.component.css'],
    providers: [JobOffersService]
})
export class NewJobOfferNewSkillComponent implements OnInit  {

    error: any;

    skill: Skill = new Skill();

    constructor(
        private router: Router,
        private jobOfferService: JobOffersService,
        private newJobOfferService: NewJobOfferService
    ) { }

    ngOnInit() {
    }


    save() {
        this.jobOfferService.saveSkill(this.skill).then(sth => {
            this.router.navigate(['/job-offers/new/skills']);
        });
    }

    cancel() {
        this.router.navigate(['/job-offers/new/skills']);
    }

}