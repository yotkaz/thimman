import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import {JobOffer} from "../../job-offer";
import {JobOffersService} from "../../job-offers.service";
import {NewJobOfferService} from "../new-job-offer.service";
import {Project} from "../../project";
import {Skill} from "../../skill";
import 'rxjs/add/operator/toPromise';

@Component({
    templateUrl: 'app/+job-offers/new/skills/new-job-offer-skills.component.html',
    styleUrls: ['app/+job-offers/new/skills/new-job-offer-skills.component.css'],
    providers: [JobOffersService]
})
export class NewJobOfferSkillsComponent implements OnInit  {

    error: any;

    jobOffer: JobOffer;

    projects: Project[];
    skills: Skill[] = [];
    requiredSkills: Skill[] = [];

    constructor(
        private router: Router,
        private jobOfferService: JobOffersService,
        private newJobOfferService: NewJobOfferService
    ) { }

    ngOnInit() {
        this.jobOffer = this.newJobOfferService.jobOffer;
        this.requiredSkills = this.jobOffer.requiredSkills;
        this.getSkills();
    }

    getProjects() {
        this.jobOfferService
            .getProjects()
            .then(projects => this.projects = projects)
            .catch(error => this.error = error); // TODO: Display error message
    }

    getSkills() {
        this.jobOfferService
            .getSkills()
            .then(skills => {
                var index;
                for (index = 0; index < skills.length; index++) {
                    if (!contains(this.requiredSkills, skills[index])) {
                        this.skills.push(skills[index]);
                    }
                }
            });
    }

    save() {
        this.jobOffer.requiredSkills = this.requiredSkills;
        this.newJobOfferService.jobOffer = this.jobOffer;
        this.jobOfferService.save(this.jobOffer).then(sth => {
            this.router.navigate(['/job-offers']);
        });
    }

    cancel() {
        this.newJobOfferService.jobOffer = new JobOffer();
        this.router.navigate(['/job-offers']);
    }

    gotoNewSkill() {
        this.jobOffer.requiredSkills = this.requiredSkills;
        this.newJobOfferService.jobOffer = this.jobOffer;
        this.router.navigate(['/job-offers/new/new-skill']);
    }

    leftClick(skill: Skill) {
        var index: number = this.skills.indexOf(skill, 0);
        if (index > -1) {
            this.skills.splice(index, 1);
        }
        this.requiredSkills.push(skill);
    }

    rightClick(skill: Skill) {
        var index: number = this.requiredSkills.indexOf(skill, 0);
        if (index > -1) {
            this.requiredSkills.splice(index, 1);
        }
        this.skills.push(skill);
    }


}

function contains(a, obj) {
    for (var i = 0; i < a.length; i++) {
        if (a[i].id == obj.id) {
            return true;
        }
    }
    return false;
}