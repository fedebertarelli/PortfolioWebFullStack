import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicio/porfolio.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from 'src/app/servicio/autenticacion.service';
import { Educacion } from 'src/app/data/Educacion';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacionList: Educacion [] = [];

  isUserLogged : Boolean = false;
  educationForm: FormGroup;

  constructor(private datosPorfolio:PorfolioService,
    private authService : AutenticacionService,
    private formBuilder : FormBuilder) {

    this.educationForm = this.formBuilder.group({
      id:[''],
      school:[''],
      title:[''],
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

    this.datosPorfolio.obtnerDatosEducacion().subscribe(
      (data) =>{
      console.log(data);
      this.educacionList=data;
      

    });

    

  }

  private clearForm(){
    
    this.educationForm.setValue({
      id:'',
      school:'',
      title:'',
      fecha_start:'',
      fecha_end:'',
      img:''
    })

  }

  private loadForm(educacion : Educacion){

    this.educationForm.setValue({
      id:educacion.id,
      school: educacion.school,
      title:educacion.title,
      fecha_start: educacion.fecha_start,
      fecha_end: educacion.fecha_end,
      img: educacion.img
    })
  }

  onSubmit(){
    let educacion : Educacion = this.educationForm.value;

    if(this.educationForm.get('id')?.value==''){
      this.datosPorfolio.guardarNuevaEducacion(educacion).subscribe(
        (newEducacion : Educacion) => {
          this.educacionList.push(newEducacion);
        }
      )
    } else{
      this.datosPorfolio.modificarEducacion(educacion).subscribe(
        () => {
          this.reloadData();
        }
      )
    }

    alert("se guardo correctamente");
    

  }

  onNewEducation(){
    this.clearForm();
  }

  onEditEducation(index: number){
    let educacion: Educacion = this.educacionList[index];
    this.loadForm(educacion);
  }

  onDeleteEducation(index: number){
    
    let educacion: Educacion = this.educacionList[index];
    console.log("el numero index es " + index + "y el id es " + educacion.id)
    if(confirm("¿Estas seguro que deseas eleminar la educacion selecionada?")){
      this.datosPorfolio.borarEducacion(educacion.id).subscribe(
        ()=> {
          this.reloadData();
        }
      )
    }
    alert("su educacion ha sido eliminada");
  }

}
