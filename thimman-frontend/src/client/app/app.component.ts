import { Component } from '@angular/core';
import { HTTP_PROVIDERS } from '@angular/http'
import { ROUTER_DIRECTIVES, Routes } from '@angular/router';

import { AboutComponent } from './+about/index';
import { HomeComponent } from './+home/index';
import { JobOffersComponent } from './+job-offers/index';
import { NavbarComponent, ToolbarComponent } from './shared/index';
import { JobOfferService } from './+job-offers/job-offers.service'

@Component({
  selector: 'sd-app',
  templateUrl: 'app/app.component.html',
  directives: [ROUTER_DIRECTIVES, NavbarComponent, ToolbarComponent],
  providers: [JobOfferService, HTTP_PROVIDERS]
})
@Routes([
  {
    path: '/',
    component: HomeComponent
  },
  {
    path: '/about',
    component: AboutComponent
  },
  {
    path: '/job-offers',
    component: JobOffersComponent
  }
])
export class AppComponent {}
