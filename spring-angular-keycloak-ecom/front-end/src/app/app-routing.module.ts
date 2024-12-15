import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {ListCustomersComponent} from './components/customers/list-customers/list-customers.component';
import {ListProductsComponent} from './components/products/list-products/list-products.component';
import {AuthGuard} from './guards/auth.guard';

const routes: Routes = [
  {path:"home", component:HomeComponent},
  { path: '', component: HomeComponent},
  {path:"customers/list", component:ListCustomersComponent, canActivate:[AuthGuard]},
  {path:"products/list", component:ListProductsComponent, canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
