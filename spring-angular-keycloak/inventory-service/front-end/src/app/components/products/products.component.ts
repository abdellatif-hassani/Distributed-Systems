import { Component } from '@angular/core';
import {ApiService} from "../../services/api.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  products: any = [];
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
