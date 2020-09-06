import { Component, OnInit } from '@angular/core';
import { InstitutionsService } from '../institutions.service';
import { Institutions } from '../dto/institutions';

@Component({
  selector: 'app-institutions',
  templateUrl: './institutions.component.html',
  styleUrls: ['./institutions.component.css']
})
export class InstitutionsComponent implements OnInit {
  institutions: Institutions[];
  constructor(private institutionsService : InstitutionsService) { }

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
    console.log('Inst selected ',institutionId);
    console.log('Inst selected service',this.institutionsService.getInstitutionSelected());
  }

}
