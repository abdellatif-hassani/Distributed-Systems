import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8889/CUSTOMER-SERVICE/api/v1/customers';

  constructor(private apiService: ApiService) {}

  public getAllCustomers(): Observable<any> {
    return this.apiService.get(this.baseUrl);
  }
}
