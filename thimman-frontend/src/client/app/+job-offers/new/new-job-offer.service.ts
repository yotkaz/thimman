import { Injectable }    from '@angular/core';
import 'rxjs/add/operator/toPromise';
import {JobOffer} from "../job-offer";

@Injectable()
export class NewJobOfferService {

    jobOffer: JobOffer = new JobOffer();

}