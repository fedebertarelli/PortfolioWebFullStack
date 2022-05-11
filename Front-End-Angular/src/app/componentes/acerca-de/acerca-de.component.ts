import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { AcercaDe } from 'src/app/data/AcercaDe';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {

  acercaDeList: AcercaDe[] = [];
  acercaDeForm: FormGroup;
  isUserLogged : Boolean = false;

  constructor(private datosPorfolio:PorfolioService,
              private authService : AutenticacionService,
              private formBuilder : FormBuilder) {

    this.acercaDeForm = this.formBuilder.group({
      id:[''],
      about:['']
     
    });

   }

  ngOnInit(): void {

    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();
  
  }

  private reloadData(){

    this.datosPorfolio.obtnerDatosAcercaDe().subscribe(
      (data) =>{
      
      this.acercaDeList=data;

    });

  }

  private loadForm(acercaDe : AcercaDe){

    this.acercaDeForm.setValue({
      id:acercaDe.id,
      about : acercaDe.about
    })
  }

  onSubmitAcercaDe(){
    let acercaDe : AcercaDe = this.acercaDeForm.value;

      this.datosPorfolio.modificarAcercaDe(acercaDe).subscribe(
        () => {
          this.reloadData();
        }
      )

    alert("se guardo correctamente");

  }

  onEditAcercaDe(index: number){
    let acercaDe: AcercaDe = this.acercaDeList[index];
    this.loadForm(acercaDe);
  }
}
