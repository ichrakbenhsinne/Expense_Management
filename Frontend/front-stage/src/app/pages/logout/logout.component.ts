import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Responsauth } from 'src/app/Responsauth';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  constructor(private service: AuthService, private router: Router) { }
 
  token!: Responsauth; 

  refreshToken:string | undefined

ngOnInit(): void {
  throw new Error('Method not implemented.');
 
}

logout(){
  this.service.logout(this.token.refresh_token);



}

}
