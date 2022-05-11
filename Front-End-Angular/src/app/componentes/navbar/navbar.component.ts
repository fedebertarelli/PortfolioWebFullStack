import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Usuario } from 'src/app/data/Usuario';
import { Router } from '@angular/router';
import { Redes } from 'src/app/data/Redes';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  redesList :Redes [] = [];
  isUserLogged : Boolean = false;
  

  constructor(private datosPorfolio:PorfolioService, 
              private authService : AutenticacionService,
               
              private ruta : Router) {

      };
  

   ngOnInit(): void {
    
    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();

    console.log(this.redesList);

  
  }

  private reloadData(){
    
    this.datosPorfolio.obtnerDatosRedes().subscribe(
      (data) =>{
      
      this.redesList=data;
      

    });

  }

  logout() : void{
    this.authService.logout();
    this.isUserLogged = false;
    window.location.reload();
   
  }

  login() :  void{    
    this.ruta.navigate(['/iniciar-sersion']);
  }

  

 
}