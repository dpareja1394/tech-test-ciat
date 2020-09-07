import { Component, OnInit } from '@angular/core';
import { Institutions } from '../dto/institutions';
import { InstitutionsService } from '../institutions.service';
import { FormControl } from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import { InstitutionTypes } from '../dto/institution-types';
import { InstitutionTypesService } from '../institution-types.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-institutions',
  templateUrl: './edit-institutions.component.html',
  styleUrls: ['./edit-institutions.component.css']
})
export class EditInstitutionsComponent implements OnInit {
  institution: Institutions = new Institutions();
  institutionTypes : InstitutionTypes[];

  acronym = new FormControl('');
  name = new FormControl('');
  websiteLink = new FormControl('');
  institutionType = new FormControl('');
  constructor(
    private institutionsService : InstitutionsService,
    private _snackBar: MatSnackBar,
    private institutionTypesService : InstitutionTypesService,
    private router:Router) {
  }
  
  ngOnInit(): void {
    this.getInstitution();
    this.getInstitutionTypes();
  }

  getInstitution(){
    let id = this.institutionsService.getInstitutionSelected();
    this.institutionsService.getInstitutionById(id).subscribe(res => {
      this.institution = res;
      console.log(typeof( this.institution));
      this.acronym.setValue(this.institution.acronym);
      this.name.setValue(this.institution.name);
      this.websiteLink.setValue(this.institution.websiteLink);
      this.institutionType.setValue(this.institution.id_InstitutionTypes);
    });
  }

  getInstitutionTypes(){
    this.institutionTypesService.getInstitutionTypes().subscribe(res=>{
      this.institutionTypes = res;
    })
  }

  updateInstitution(){
    this.institution.acronym = this.acronym.value;
    this.institution.name = this.name.value;
    this.institution.websiteLink = this.websiteLink.value;
    this.institution.id_InstitutionTypes = this.institutionType.value;
    this.institutionsService.updateInstitution(this.institution).subscribe(res=>{
      this.router.navigate(['institutions']);
      this.showUpdatedSnackBar();
    },err=>{
      this.showErrorSnackBar();
    });
  }

  showUpdatedSnackBar() {
    this._snackBar.open('Institution Updated',);
  }
  showErrorSnackBar() {
    this._snackBar.open('Error while you was updating the Institution');
  }
  
}
