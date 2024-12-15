import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {}

  // Generic GET method
  public get<T>(url: string): Observable<T> {
    return this.httpClient.get<T>(url);
  }

  // Generic POST method
  public post<T>(url: string, body: any): Observable<T> {
    return this.httpClient.post<T>(url, body);
  }

  // Generic PUT method
  public put<T>(url: string, body: any): Observable<T> {
    return this.httpClient.put<T>(url, body);
  }

  // Generic DELETE method
  public delete<T>(url: string): Observable<T> {
    return this.httpClient.delete<T>(url);
  }
}
