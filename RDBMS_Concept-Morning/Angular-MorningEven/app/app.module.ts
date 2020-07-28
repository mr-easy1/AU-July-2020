import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DatasetService  } from './dataset.service';
import { FormdetailComponent } from './formdetail/formdetail.component'

@NgModule({
  declarations: [
    AppComponent,
    FormdetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    DatasetService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { 
  title = "My-project";
}


