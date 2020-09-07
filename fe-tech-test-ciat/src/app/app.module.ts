import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InstitutionsComponent } from './institutions/institutions.component';
import { HttpClientModule } from '@angular/common/http';
import { InstitutionsService } from './institutions.service';
import { EditInstitutionsComponent } from './edit-institutions/edit-institutions.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { InstitutionTypesService } from './institution-types.service';
@NgModule({
  declarations: [
    AppComponent,
    InstitutionsComponent,
    EditInstitutionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatSnackBarModule
 
  ],
  providers: [
    InstitutionsService,
    InstitutionTypesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
