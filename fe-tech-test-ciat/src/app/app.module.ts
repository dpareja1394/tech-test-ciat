import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InstitutionsComponent } from './institutions/institutions.component';
import { HttpClientModule } from '@angular/common/http';
import { InstitutionsService } from './institutions.service';

@NgModule({
  declarations: [
    AppComponent,
    InstitutionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [
    InstitutionsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }