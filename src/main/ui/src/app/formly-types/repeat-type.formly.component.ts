import { Component } from '@angular/core';
import { FieldArrayType } from '@ngx-formly/core';

@Component({
  selector: 'formly-repeat-section',
  template: `
    <div *ngFor="let field of field.fieldGroup; let i = index;" class="card my-1">
      <div class="card-body d-flex flex-row justify-content-between align-items-center">
        <formly-field [field]="field"></formly-field>
        <button class="btn btn-info ml-2" type="button" (click)="remove(i)">Entfernen</button>
      </div>
    </div>
    <div class="mt-2">
      <button class="btn btn-info" type="button" (click)="add()">{{ to.addText }}</button>
    </div>
  `,
})
export class RepeatTypeComponent extends FieldArrayType {}
