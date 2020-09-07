import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstitutionTypesService {
  url: String = environment.baseUrl + 'institutionTypes/';

  constructor(private http: HttpClient) { }

  public getInstitutionTypes():Observable<any> {
    return this.http.get(this.url+'findAll');
  }
}
