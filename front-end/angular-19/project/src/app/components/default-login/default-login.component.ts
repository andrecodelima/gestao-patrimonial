import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-default-login',
  imports: [MatFormFieldModule, MatInputModule, MatIconModule,ButtonModule],
  templateUrl: './default-login.component.html',
  styleUrl: './default-login.component.scss'
})
export class DefaultLoginComponent {

}
