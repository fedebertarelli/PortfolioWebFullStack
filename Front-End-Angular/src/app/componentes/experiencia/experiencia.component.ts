import { APP_BOOTSTRAP_LISTENER, Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Experiencia } from 'src/app/data/Experiencia';
import { Router } from '@angular/router';


@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  experienciaList: Experiencia[] = [];
  experienciaForm: FormGroup;
  isUserLogged : Boolean = false;
	

  constructor(private datosPorfolio:PorfolioService,
                private authService : AutenticacionService,
                private formBuilder : FormBuilder,
                private ruta:Router) {

    this.experienciaForm = this.formBuilder.group({
      id:[''],
      company:[''],
      position:[''],
      fecha_start:[''],
      fecha_end:[''],
      img:['']
    });

   }

  ngOnInit(): void {

    this.isUserLogged = this.authService.isUserLogged();
    this.reloadData();
    
  
  }

  private reloadData(){

    this.datosPorfolio.obtnerDatosExperiencia().subscribe(
      (data) =>{
      
        this.experienciaList=data;

    });

  }

  private clearForm(){
    
    this.experienciaForm.setValue({
      id:'',
      company:'',
      position:'',
      fecha_start:'',
      fecha_end:'',
      img:''
    })

  }

  private loadForm(experiencia : Experiencia){

    this.experienciaForm.setValue({
      id: experiencia.id,
      company: experiencia.company,
      position: experiencia.position,
      fecha_start: experiencia.fecha_start,
      fecha_end: experiencia.fecha_end,
      img: experiencia.img
    })
  }


  onSubmit(){
    let experiencia : Experiencia = this.experienciaForm.value;
    

    if(this.experienciaForm.get('id')?.value==''){
      this.datosPorfolio.guardarNuevaExperiencia(experiencia).subscribe(
        (newExperiencia : Experiencia) => {
          this.experienciaList.push(newExperiencia);
        }
      )
    } else{
      this.datosPorfolio.modificarExperiencia(experiencia).subscribe(
        () => {
          this.reloadData();
        }
      )
    }
    alert("se guardo correctamente");

  }

  
  onNewExperiencia(){
    this.clearForm();
  }

  onEditExperiencia(index: number){
    let experiencia: Experiencia = this.experienciaList[index];
    this.loadForm(experiencia);
  }

  onDeleteExperiencia(index: number){
    
    let experiencia: Experiencia = this.experienciaList[index];
    console.log("el numero index es " + index + "y el id es " + experiencia.id)
    if(confirm("¿Estas seguro que deseas eleminar la educacion selecionada?")){
      this.datosPorfolio.borarExperiencia(experiencia.id).subscribe(
        ()=> {
          this.reloadData();
        }
      )
    }
    alert("su experiencia ha sido eliminada");
  }


}