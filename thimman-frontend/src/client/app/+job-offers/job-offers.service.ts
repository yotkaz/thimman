import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { JobOffer } from './job-offer';
import {Project} from "./project";
import {Skill} from "./skill";
import {Challenge} from "./challenge";

@Injectable()
export class JobOffersService {
    // TODO: burn it all
    // I don't have time to write all these things in 'clear' way
    private baseUrl = 'http://dev4.yotkaz.me';
    private jobOffersUrl = this.baseUrl + '/job-offers';
    private testsUrl = this.baseUrl + '/challenges/tests';
    private tasksUrl = this.baseUrl + '/challenges/tasks';
    private projectsUrl = this.baseUrl + '/projects';
    private skillsUrl = this.baseUrl + '/skills';

    private headersGet = new Headers();
    private headersPost = new Headers();

    constructor(private http: Http) {
        this.headersGet
            .append('Authorization', 'Basic ' + btoa("admin:admin")); // TODO: auth
        this.headersPost
            .append('Content-Type', 'application/json');
        this.headersPost
            .append('Authorization', 'Basic ' + btoa("admin:admin"));
        this.headersPost
            .append('Accept', 'application/json');
    }

    getJobOffers(): Promise<JobOffer[]> {
        return this.http.get(this.jobOffersUrl, {
            headers: this.headersGet
        })
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    getJobOffer(id: number): Promise<JobOffer> {
        return this.http.get(this.jobOffersUrl + '/' + id)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    save(jobOffer: JobOffer): Promise<JobOffer>  {
        if (jobOffer.id) {
            return this.put(jobOffer);
        }
        return this.post(jobOffer);
    }

    delete(jobOffer: JobOffer) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        let url = `${this.jobOffersUrl}/${jobOffer.id}`;
        return this.http
            .delete(url, headers)
            .toPromise()
            .catch(this.handleError);
    }

    private post(jobOffer: JobOffer) {
        return this.http
            .post(this.jobOffersUrl, JSON.stringify(jobOffer), {headers: this.headersPost})
            .toPromise()
            .catch(this.handleError);
    }

    private put(jobOffer: JobOffer) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        let url = `${this.jobOffersUrl}/${jobOffer.id}`;
        return this.http
            .put(url, JSON.stringify(jobOffer), {headers: headers})
            .toPromise()
            .catch(this.handleError);
    }

    getProjects(): Promise<Project[]> {
        return this.http.get(this.projectsUrl, {
            headers: this.headersGet
        })
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    getSkills(): Promise<Skill[]> {
        return this.http.get(this.skillsUrl, {
            headers: this.headersGet
        })
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    getTests(): Promise<Challenge[]> {
        return this.http.get(this.testsUrl, {
            headers: this.headersGet
        })
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    getTasks(): Promise<Challenge[]> {
        return this.http.get(this.tasksUrl, {
            headers: this.headersGet
        })
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }

    saveSkill(skill: Skill) {
        return this.http
            .post(this.skillsUrl, JSON.stringify(skill), {headers: this.headersPost})
            .toPromise()
            .catch(this.handleError);
    }

    private handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}