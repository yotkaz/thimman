import { provideRouter, RouterConfig } from '@angular/router';
import {AboutComponent} from "./+about/about.component";
import {HomeComponent} from "./+home/home.component";
import {JobOfferRoutes} from "./+job-offers/job-offers.routes";

const routes: RouterConfig = [
    {
        path: '/',
        component: HomeComponent,
        index: true
    },
    {
        path: '/about',
        component: AboutComponent
    },
    ...JobOfferRoutes
];

export const APP_ROUTER_PROVIDERS = [
    provideRouter(routes)
];