import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {PropertyServiceService} from "./property-service.service";
import {Tip} from "./tip";
import {AllTips} from "./allTips";

@Injectable({
  providedIn: 'root'
})
export class TipServiceService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  constructor(private http: HttpClient, private propertyService: PropertyServiceService) {
  }

  getThisUrl() {
    return 'rest/api/tip';
  }

  getUrl() {
    return this.propertyService.getBackendUrl() + this.getThisUrl();
  }

  getAllTips() {
    return this.http.get<AllTips>(this.getUrl());
  }

  addNewTip(tip: Tip) {
    return this.http.post<Tip>(this.getUrl(), tip, this.httpOptions);
  }
}
