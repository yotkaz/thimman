import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { JobOffer } from './job-offer';

@Injectable()
export class JobOfferService {
    private jobOffersUrl = 'http://localhost:18804/job-offers';

    constructor(private http: Http) { }

    getJobOffers(): Promise<JobOffer[]> {
        let headers = new Headers();
        headers.append('Authorization', 'Basic ' + btoa("admin:admin")); // TODO: auth
        return this.http.get(this.jobOffersUrl, {
            headers: headers
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

    private post(jobOffer: JobOffer): Promise<JobOffer> {
        let headers = new Headers({
            'Content-Type': 'application/json'});
        return this.http
            .post(this.jobOffersUrl, JSON.stringify(jobOffer), {headers: headers})
            .toPromise()
            .then(res => res.json().data)
            .catch(this.handleError);
    }

    private put(jobOffer: JobOffer) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        let url = `${this.jobOffersUrl}/${jobOffer.id}`;
        return this.http
            .put(url, JSON.stringify(jobOffer), {headers: headers})
            .toPromise()
            .then(() => jobOffer)
            .catch(this.handleError);
    }

    private handleError(error: any) {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }
}