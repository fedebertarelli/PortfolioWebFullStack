import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable  } from 'rxjs';
import { map } from 'rxjs/operators';
import { config } from '../data/config/Config';




@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  
  currentUserSubject: BehaviorSubject<any>;


  constructor(private http: HttpClient) {
    console.log("El servicio de autenticación está coriendo")
    this.currentUserSubject = new BehaviorSubject<any>(
      JSON.parse(sessionStorage.getItem('currentUser') || '{}'))
   }

   IniciarSession(credenciales : any): Observable<any>{
     return this.http.post(config.baseUrl + "login", credenciales).pipe(map(data =>{
       sessionStorage.setItem('currentUser', JSON.stringify(data))
       this.currentUserSubject.next(data)    
       return data;
       
     }))
   }

   public logout(){
     sessionStorage.removeItem('currentUser');   
   }

   public isUserLogged() : boolean{  
     return sessionStorage.getItem('currentUser') !== null;
   }
}
