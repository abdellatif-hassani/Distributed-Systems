import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DefaultComponent} from "./components/default/default.component";
import {ProductsComponent} from "./components/products/products.component";
import {CustomersComponent} from "./components/customers/customers.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  {path: '', component: DefaultComponent},
  {path: 'home', redirectTo: ''},
  {path: 'products', component: ProductsComponent, canActivate: [AuthGuard], data: {roles: ['USER']} },
  {path: 'customers', component: CustomersComponent, canActivate: [AuthGuard], data: {roles: ['ADMIN']} },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
