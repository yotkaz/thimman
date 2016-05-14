import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES, Routes } from '@angular/router';

import { AboutComponent } from './+about/index';
import { HomeComponent } from './+home/index';
import { JobOffersComponent } from './+job-offers/index';
import { NavbarComponent, ToolbarComponent } from './shared/index';

@Component({
  selector: 'sd-app',
  templateUrl: 'app/app.component.html',
  directives: [ROUTER_DIRECTIVES, NavbarComponent, ToolbarComponent]
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