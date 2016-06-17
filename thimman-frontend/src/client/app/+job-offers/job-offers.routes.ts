import {JobOffersComponent} from "./list/job-offers.component";
import {NewJobOfferComponent} from "./new/new-job-offer.component";
import {NewJobOfferStartComponent} from "./new/start/new-job-offer-start.component";
import {NewJobOfferSkillsComponent} from "./new/skills/new-job-offer-skills.component";
export const JobOfferRoutes = [
    {
        path: '/job-offers',
        component: JobOffersComponent,
    },
    {
        path: '/job-offers/new',
        component: NewJobOfferComponent,
        children: [
            {
                path: '/',
                component: NewJobOfferStartComponent,
                index: true
            },
            {
                path: '/start',
                component: NewJobOfferStartComponent,
            },
            {
                path: '/skills',
                component: NewJobOfferSkillsComponent,
            }
        ]
    }
];