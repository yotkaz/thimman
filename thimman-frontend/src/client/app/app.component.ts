import { Component } from '@angular/core';
import { HTTP_PROVIDERS } from '@angular/http';
import { ROUTER_DIRECTIVES} from '@angular/router';
import { NavbarComponent, ToolbarComponent } from './shared/index';

@Component({
  selector: 'sd-app',
  templateUrl: 'app/app.component.html',
  directives: [ROUTER_DIRECTIVES, NavbarComponent, ToolbarComponent],
  providers: [HTTP_PROVIDERS]
})
export class AppComponent {}
