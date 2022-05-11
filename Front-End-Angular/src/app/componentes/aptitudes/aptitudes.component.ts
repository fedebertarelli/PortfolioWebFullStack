import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Aptitud } from 'src/app/data/Aptitud';


@Component({
  selector: 'app-aptitudes',
  templateUrl: './aptitudes.component.html',
  styleUrls: ['./aptitudes.component.css']
})
export class AptitudesComponent implements OnInit {
  aptitudList: Aptitud [] = [];
  aptitudForm: FormGroup;
  isUserLogged : Boolean = false;


constructor(private datosPorfolio:PorfolioService, 
            private authService : AutenticacionService,
            private formBuilder : FormBuilder) {

    this.aptitudForm = this.formBuilder.group({
      id:[''],
      name:[''],
      progress:['']
   
    });

}

  ngOnInit(): void {

    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();
  
  }

  private reloadData(){

    this.datosPorfolio.obtnerDatosAptitud().subscribe(
      (data) =>{
      
      this.aptitudList=data;

    });

  }

  
  private clearForm(){
    
    this.aptitudForm.setValue({
      id:'',
      name:'',
      progress:''
    })

  }

  private loadForm(aptitud: Aptitud){

    this.aptitudForm.setValue({
      id:aptitud.id,
      name:aptitud.name,
      progress:aptitud.progress
    })
  }

  onSubmit(){
    let aptitud : Aptitud = this.aptitudForm.value;

    if(this.aptitudForm.get('id')?.value==''){
      this.datosPorfolio.guardarNuevaAptitud(aptitud).subscribe(
        (newAptitud : Aptitud) => {
          this.aptitudList.push(newAptitud);
        }
      )
    } else{
      this.datosPorfolio.modificarAptitud(aptitud).subscribe(
        () => {
          this.reloadData();
        }
      )
    }

    alert("se guardo correctamente");

  }

  
  onNewAptitud(){
    this.clearForm();
  }

  onEditAptitud(index: number){
    let aptitud: Aptitud = this.aptitudList[index];
    this.loadForm(aptitud);
  }

  onDeleteAptitud(index: number){
    
    let aptitud: Aptitud = this.aptitudList[index];
    console.log("el numero index es " + index + "y el id es " + aptitud.id)
    if(confirm("¿Estas seguro que deseas eleminar la educacion selecionada?")){
      this.datosPorfolio.borarAptitud(aptitud.id).subscribe(
        ()=> {
          this.reloadData();
        }
      )
    }
    alert("Ha sido eliminado");
  }
}

