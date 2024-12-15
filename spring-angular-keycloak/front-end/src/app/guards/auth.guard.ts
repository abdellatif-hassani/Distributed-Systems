import { Injectable } from '@angular/core';
import { 
  CanActivate, 
  Router, 
  ActivatedRouteSnapshot, 
  RouterStateSnapshot 
} from '@angular/router';
import { KeycloakService } from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private keycloakService: KeycloakService,
    private router: Router
  ) {}

  async canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot
  ): Promise<boolean> {
    try {
      const isLoggedIn = await this.keycloakService.isLoggedIn();
  
      if (!isLoggedIn) {
        // Keycloak will handle the login redirect automatically
        return false;
      }
  
      // Optional: Role-based access control
      const requiredRoles = route.data['roles'] as string[];
      if (requiredRoles) {
        const userRoles = this.keycloakService.getUserRoles();
        const hasRequiredRoles = requiredRoles.every(role => 
          userRoles.includes(role)
        );
  
        if (!hasRequiredRoles) {
          this.router.navigate(['/unauthorized']);
          return false;
        }
      }
  
      return true;
    } catch (error) {
      console.error('Authentication check failed', error);
      return false;
    }
  }
}