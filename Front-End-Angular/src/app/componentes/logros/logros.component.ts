import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Logro } from 'src/app/data/Logro';


@Component({
  selector: 'app-logros',
  templateUrl: './logros.component.html',
  styleUrls: ['./logros.component.css']
})
export class LogrosComponent implements OnInit {

  logroList: Logro [] = [];
  logroForm: FormGroup;
  isUserLogged : Boolean = false;

  constructor(private datosPorfolio:PorfolioService, 
              private authService : AutenticacionService,
              private formBuilder : FormBuilder) {

    this.logroForm = this.formBuilder.group({
      id:[''],
      name:[''],
      descripcion:['']
    });

   }

  ngOnInit(): void {

    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();
  
  }

  private reloadData(){

    this.datosPorfolio.obtnerDatosLogro().subscribe(
      (data) =>{
      
      this.logroList=data;
    });

  }

  
  private clearForm(){
    
    this.logroForm.setValue({
      id:'',
      name:'',
      descripcion:''
    })

  }

  private loadForm(logro : Logro){

    this.logroForm.setValue({
      id:logro.id,
      name:logro.name,
      descripcion: logro.descripcion
    })
  }

  onSubmit(){
    let logro : Logro = this.logroForm.value;

    if(this.logroForm.get('id')?.value==''){
      this.datosPorfolio.guardarNuevoLogro(logro).subscribe(
        (newLogro : Logro) => {
          this.logroList.push(newLogro);
        }
      )
    } else{
      this.datosPorfolio.modificarLogro(logro).subscribe(
        () => {
          this.reloadData();
        }
      )
    }
    
    alert("se guardo correctamente");
  }

  
  onNewLogro(){
    this.clearForm();
  }

  onEditLogro(index: number){
    let logro : Logro = this.logroList[index];
    this.loadForm(logro);
  }

  onDeleteLogro(index: number){
    
    let logro : Logro = this.logroList[index];
    console.log("el numero index es " + index + "y el id es " + logro.id)
    if(confirm("¿Estas seguro que deseas eleminar el proyecto selecionado?")){
      this.datosPorfolio.borarLogro(logro.id).subscribe(
        ()=> {
          this.reloadData();
        }
      )
    }
    alert("Ha sido eliminado");
  }



}