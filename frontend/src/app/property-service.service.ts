import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PropertyServiceService {

  constructor() { }

  getBackendUrl() {
    return 'http://localhost:8080/';
  }
}
