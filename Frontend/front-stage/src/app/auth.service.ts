import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { User } from 'User';
import { Responsauth } from './Responsauth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = "http://localhost:9008/auth/";
   token:Responsauth | undefined
  constructor(private http: HttpClient) { }

  //authenticate user
  authentication(user: User): Observable<Responsauth> {
    return this.http.post<Responsauth>(`${this.url}login`, user);
  }


  
  //token state 
  tokenstate(refreshToken: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.url}introspect`, { refreshToken });
  }

   //token state 
   logout(refreshToken: string): Observable<boolean> {
    return this.http.post<boolean>(`${this.url}logout`, { refreshToken });
  }


  
}


