import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../../services/customer/customer.service';

@Component({
  selector: 'app-list-customers',
  standalone: false,

  templateUrl: './list-customers.component.html',
  styleUrl: './list-customers.component.css'
})
export class ListCustomersComponent implements OnInit{
  customers: any;
  constructor(private customerService: CustomerService) {
  }
  ngOnInit(): void {
    this.loadCustomers();
  }

  private loadCustomers(): void {
    this.customerService.getAllCustomers().subscribe({
      next: (res) => {
        console.log('Customers loaded:', res);
        this.customers = res;
      },
      error: (err) => {
        console.error('Error loading customers:', err);
      }
    });
  }

}
