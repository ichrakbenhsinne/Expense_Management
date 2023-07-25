import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'User';
import { Responsauth } from 'src/app/Responsauth';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  form = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });

  constructor(private service: AuthService, private router: Router) { }
  data: any;
  resp: Responsauth | null | undefined;
  refresh_token: string | undefined;
  auth: boolean | undefined;

  submit() {
    if (this.form.valid) {
      const user: User = {
        username: this.form.value.username ?? '',
        password: this.form.value.password ?? ''
      };

      this.service.authentication(user).subscribe({
        next: data => {
          this.resp = data;
          console.log(this.resp);
          // Gérez la réponse de Keycloak ici

          // Si le token n'est pas null
          if (this.resp && this.resp.refresh_token) {
            this.refresh_token = this.resp.refresh_token;
            this.service.tokenstate(this.refresh_token).subscribe({
              next: auth => {
                if (auth) {
                  console.log("Welcome!");
                  //this.router.navigate(['/home']);
                } else {
                  console.log("Session terminée!");
                  this.resp = undefined;
                  // this.router.navigate(['/session-ended']);
                }
              },
              error: error => {
                console.log(error);
                // Gérez les erreurs ici
              }
            });
          } else {
            console.log("User n'existe pas !!");
            //this.router.navigate(['/user-not-found']);
          }
        },
        error: error => {
          console.log(error);
          // Gérez les erreurs ici
        }
      });
    }
  }

  ngOnInit(): void {
  }

}
