import { Component, OnInit } from '@angular/core';
import { InstitutionsService } from '../institutions.service';
import { Institutions } from '../dto/institutions';
import { Router } from '@angular/router';

@Component({
  selector: 'app-institutions',
  templateUrl: './institutions.component.html',
  styleUrls: ['./institutions.component.css']
})
export class InstitutionsComponent implements OnInit {
  institutions: Institutions[];
  constructor(private institutionsService : InstitutionsService,
    private router:Router) { }

  ngOnInit(): void {
    this.getInstitutions();
  }

  getInstitutions(){
    this.institutionsService.getInstitutions().subscribe(res =>{
      this.institutions = res;
    })
  }

  editInstitution(institutionId:number){
    this.institutionsService.setInstitutionSelected(institutionId);
    this.router.navigate(['edit-institutions']);
  }

}
