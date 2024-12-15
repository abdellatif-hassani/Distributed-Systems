import { Component } from '@angular/core';
import {CustomerService} from '../../../services/customer/customer.service';
import {ProductService} from '../../../services/product/product.service';

@Component({
  selector: 'app-list-products',
  standalone: false,

  templateUrl: './list-products.component.html',
  styleUrl: './list-products.component.css'
})
export class ListProductsComponent {
  products: any;
  constructor(private productService: ProductService) {
  }
  ngOnInit(): void {
    this.loadCustomers();
  }

  private loadCustomers(): void {
    this.productService.getAllProducts().subscribe({
      next: (res) => {
        console.log('Products loaded:', res);
        this.products = res;
      },
      error: (err) => {
        console.error('Error loading products:', err);
      }
    });
  }
}
