import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Person } from '../models/Person';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AsstesService {

  API_URI = 'http://localhost:3000/AssetsCrud.wsdl';

  constructor(private http: HttpClient) { }

  getPerson() {
    return this.http.get(`${this.API_URI}/listPerson`);
  }

  getArea() {
    return this.http.get(`${this.API_URI}/area`);
  }

  getAssets() {
    return this.http.get(`${this.API_URI}/assest`);
  }

  getSearchAssets(id: string) {
    return this.http.get(`${this.API_URI}/assest/${id}`);
  }

  saveAssets(person: Person) {
    return this.http.post(`${this.API_URI}/area/add`, person);
  }
  /*
    upadteAssets(id: string, updateName: Person): Observable<Person> {
      return this.http.put(`${this.API_URI}/area/${id}`, updateName);
    }*/
}
