import { Component } from '@angular/core';
import { FieldWrapper } from '@ngx-formly/core';

@Component({
  selector: 'formly-wrapper-panel',
  template: `
    <div class="card" style="margin-top:10px; border-style:solid; border-width:1px;border-color:LightGrey">
      <div class="card-body">
        <h5 class="card-title">{{ to.label }}</h5>
        <div #fieldComponent></div>
      </div>
    </div>
  `,
})
export class PanelWrapperComponent extends FieldWrapper {
}
