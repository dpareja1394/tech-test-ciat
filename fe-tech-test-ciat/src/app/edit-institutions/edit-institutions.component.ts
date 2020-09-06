import { Component, OnInit } from '@angular/core';
import { Institutions } from '../dto/institutions';
import { InstitutionsService } from '../institutions.service';

@Component({
  selector: 'app-edit-institutions',
  templateUrl: './edit-institutions.component.html',
  styleUrls: ['./edit-institutions.component.css']
})
export class EditInstitutionsComponent implements OnInit {
  institution: Institutions;
  show:boolean = false;
  constructor(private institutionsService : InstitutionsService) {
  }
  
  ngOnInit(): void {
    this.getInstitution();
    
  }

  getInstitution(){
    let id = this.institutionsService.getInstitutionSelected();
    this.institutionsService.getInstitutionById(id).subscribe(res => {
      this.institution = res;
      console.log(JSON.stringify(this.institution));
      this.show = true;
    })
  }
}
