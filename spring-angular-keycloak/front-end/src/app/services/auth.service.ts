import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private keycloakService: KeycloakService) {}

  // Login method
  public login(): void {
    this.keycloakService.login();
  }

  // Logout method with optional redirectUri
  public logout(redirectUri: string = window.location.origin): void {
    this.keycloakService.logout(redirectUri);
  }

  public async getUserProfile(): Promise<KeycloakProfile | null> {
  try {
    return await this.keycloakService.loadUserProfile();
  } catch (error) {
    console.error('Failed to load user profile', error);
    return null;
  }
}

public async getToken(): Promise<string | null> {
  try {
    return await this.keycloakService.getToken();
  } catch (error) {
    console.error('Failed to get token', error);
    return null;
  }
}

  // Check if user is logged in
  public async isLoggedIn(): Promise<boolean> {
    return this.keycloakService.isLoggedIn();
  }

  // Get user roles
  public getUserRoles(): string[] {
    return this.keycloakService.getUserRoles();
  }

  // Check if user has a specific role
  public hasRole(role: string): boolean {
    return this.keycloakService.getUserRoles().includes(role);
  }
}
