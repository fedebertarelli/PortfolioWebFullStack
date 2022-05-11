import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Encabezado } from 'src/app/data/Encabezado';

@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
})
export class EncabezadoComponent implements OnInit {
  encabezadoList: Encabezado [] = [];
  encabezadoForm: FormGroup;
  isUserLogged : Boolean = false;

  constructor(private datosPorfolio:PorfolioService,
              private authService : AutenticacionService,
              private formBuilder : FormBuilder) {

    this.encabezadoForm = this.formBuilder.group({
      id:[''],
      backImage:[''],
      imgCV:[''],
      name:[''],
      position:[''],
      ubication:[''],
      imgCompany:[''],
      nameCompany:[''],
      imgSchool:[''],
      nameSchool:['']
    });

   }

  ngOnInit(): void {

    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();
  
  }

  private reloadData(){

    this.datosPorfolio.obtnerDatosEncabezado().subscribe(
      (data) =>{
      
      this.encabezadoList=data;

    });

  }

  getEncabezadobackImagen(){
    let encabezado : Encabezado = this.encabezadoForm.value;
    return encabezado.backImage
  }
  
  private loadForm(encabezado : Encabezado){

    this.encabezadoForm.setValue({
      id:encabezado.id,
      backImage: encabezado.backImage,
      imgCV: encabezado.imgCV,
      name: encabezado.name,
      position: encabezado.position,
      ubication: encabezado.ubication,
      imgCompany: encabezado.imgCompany,
      nameCompany: encabezado.nameCompany,
      imgSchool: encabezado.imgSchool,
      nameSchool: encabezado.nameSchool
    })
  }

  onSubmit(){
    let encabezado : Encabezado = this.encabezadoForm.value;

      this.datosPorfolio.modificarEncabezado(encabezado).subscribe(
        () => {
          this.reloadData();
        }
      )

      alert("se guardo correctamente");

  }

  onEditEncabezado(index: number){
    let encabezado: Encabezado = this.encabezadoList[index];
    this.loadForm(encabezado)
  }


}
