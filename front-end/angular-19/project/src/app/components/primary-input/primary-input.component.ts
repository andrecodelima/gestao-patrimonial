import {ChangeDetectionStrategy, Component, signal} from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';   
import {MatButtonModule} from '@angular/material/button';
import { IftaLabelModule } from 'primeng/iftalabel';


import { InputIconModule } from 'primeng/inputicon';
import { IconFieldModule } from 'primeng/iconfield';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-primary-input',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatIconModule,MatButtonModule,
    IftaLabelModule,
    InputIconModule,
    IconFieldModule,
    InputTextModule,
    FormsModule
  ],
  templateUrl: './primary-input.component.html',
  styleUrls: ['./primary-input.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,


})
export class PrimaryInputComponent {
  hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

   
}
