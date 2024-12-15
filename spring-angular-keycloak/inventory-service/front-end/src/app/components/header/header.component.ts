import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {
  username: string = '';
  ngOnInit() {
    if (this.authService.isLoggedIn()) {
      this.authService.loadUserProfile().then(r => {
        this.username = r.username;
      });
    }
  }

  constructor(public authService: KeycloakService) {
  }
  handleLogout() {
    //logout and redirect to home page
    this.authService.logout('http://localhost:4200').then(r => {
      console.log(r);
    });
  }

  async handleLogin() {
    await this.authService.login().then(r => console.log(r));
  }
}
