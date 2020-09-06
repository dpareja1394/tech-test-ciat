import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InstitutionsComponent } from './institutions/institutions.component';
import { EditInstitutionsComponent } from './edit-institutions/edit-institutions.component';

const routes: Routes = [
  { path: 'institutions', component: InstitutionsComponent },
  { path: 'edit-institutions', component: EditInstitutionsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
