import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstitutionsService {
  url: String = environment.baseUrl + 'institutions/';
  private institutionSelected:number;
  constructor(private http: HttpClient) { }

  public getInstitutions():Observable<any> {
    return this.http.get(this.url+'findAll');
  }

  public getInstitutionById(institutionId:number):Observable<any>{
    return this.http.get(this.url+'findById/'+institutionId);
  }

  //Encapsulated InstitutionSelected
  public getInstitutionSelected(){
    return this.institutionSelected;
  }
  public setInstitutionSelected(institutionSelected:number){
    this.institutionSelected = institutionSelected;
  }

}
