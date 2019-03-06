import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Person } from '../models/Person';
@Injectable({
  providedIn: 'root'
})
export class AsstesService {

  API_URI = ' http://localhost:8084/ApiRest/rest';

  constructor(private http: HttpClient) { }

  getAsstes() {
    return this.http.get(`${this.API_URI}/assets/help`);
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
