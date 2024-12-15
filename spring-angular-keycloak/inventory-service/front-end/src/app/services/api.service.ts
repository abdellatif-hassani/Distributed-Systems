import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ApiService implements OnInit{

  constructor(private http: HttpClient) {

  }
  ngOnInit() {
  }

  getProducts():Observable<any> {
    return this.http.get('http://localhost:8080/api/products', {headers: {
        'Authorization': 'Bearer ' + localStorage.getItem('token')
      }});
  }
}
