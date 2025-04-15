import {Component} from '@angular/core';

import { ButtonModule } from 'primeng/button';
import { PrimaryInputComponent } from "../primary-input/primary-input.component";

@Component({
  selector: 'app-default-login',
  imports: [ButtonModule, PrimaryInputComponent],
  templateUrl: './default-login.component.html',
  styleUrl: './default-login.component.scss'
})
export class DefaultLoginComponent {

}
