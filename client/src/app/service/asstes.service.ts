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
    return this.http.get(`${this.API_URI}/assets/listassest`);
  }

  getSearchAssets(id: string) {
    return this.http.get(`${this.API_URI}/assets/getid/${id}`);
  }

  getTypeAssig() {
    return this.http.get(`${this.API_URI}/typeassig/`);
  }

  getArea() {
    return this.http.get(`${this.API_URI}/area/`);
  }

  getPerson() {
    return this.http.get(`${this.API_URI}/person/`);
  }

  getStatus() {
    return this.http.get(`${this.API_URI}/status/`);
  }

  saveAssets(person: Person) {
    return this.http.post(`${this.API_URI}/area/add`, person);
  }
}
