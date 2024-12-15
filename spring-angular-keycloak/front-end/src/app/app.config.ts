import { APP_INITIALIZER, ApplicationConfig } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

export function initializeKeycloak(keycloak: KeycloakService) {
    return () =>
      keycloak.init({
        config: {
          url: 'http://localhost:8078',
          realm: 'TP-spring-angular',
          clientId: 'front-end'
        },
        initOptions: {
          onLoad: 'login-required', // This will trigger Keycloak's default login page
          flow: 'standard'  // Explicitly set standard login flow
        },
        bearerExcludedUrls: ['/assets', '/public'] 
      });
  }

export const appConfig: ApplicationConfig = {
  providers: [
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }
  ]
};