import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FormlyModule } from '@ngx-formly/core';
import { FormlyBootstrapModule } from '@ngx-formly/bootstrap';
import { RepeatTypeComponent } from './formly-types/repeat-type.formly.component'
import { PanelWrapperComponent } from './formly-types/panel-wrapper.formly.component';

import { FormComponent } from './form/form.component';
import { EhrComponent } from './ehr/ehr.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    RepeatTypeComponent,
    PanelWrapperComponent,
    FormComponent,
    EhrComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormlyModule.forRoot(
      {
        extras: { lazyRender: true } ,
         types: [
          { name: 'repeat', component: RepeatTypeComponent },
        ],
         wrappers: [
          { name: 'panel', component: PanelWrapperComponent },
        ]
    }),
    FormlyBootstrapModule,
    HttpClientModule,
    NgbModule,
    FontAwesomeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
