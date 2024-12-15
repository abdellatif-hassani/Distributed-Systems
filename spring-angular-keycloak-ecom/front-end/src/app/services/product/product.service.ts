import { Injectable } from '@angular/core';
import { ApiService } from '../api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8889/INVENTORY-SERVICE/api/v1/products';

  constructor(private apiService: ApiService) {}

  public getAllProducts(): Observable<any> {
    return this.apiService.get(this.baseUrl);
  }
}
