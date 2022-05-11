import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../data/Educacion';
import { config } from '../data/config/Config';
import { Experiencia } from '../data/Experiencia';
import { AcercaDe } from '../data/AcercaDe';
import { Aptitud } from '../data/Aptitud';
import { Encabezado } from '../data/Encabezado';
import { Logro } from '../data/Logro';
import { Usuario } from '../data/Usuario';
import {Redes} from '../data/Redes'



@Injectable({
  providedIn: 'root'
})
export class PorfolioService {
  

  constructor(private http:HttpClient) { }

  obtnerDatosEducacion() : Observable<Educacion[]>{

    return this.http.get<any>(config.baseUrl + "educacion");

  }

  guardarNuevaEducacion(educacion : Educacion) : Observable<Educacion>{
  
    return this.http.post<any>(config.baseUrl + "educacion/crear", educacion);

  }

  modificarEducacion(educacion : Educacion) : Observable<any>{
  
    return this.http.put<any>(config.baseUrl + "educacion/update", educacion);

  }

  borarEducacion(id : number) : Observable<any>{
  
    return this.http.delete<any>(config.baseUrl + "educacion/" + id);

  }


 obtnerDatosExperiencia() : Observable<Experiencia[]>{

  return this.http.get<any>(config.baseUrl + "experiencia");

}

  guardarNuevaExperiencia(experiencia : Experiencia) : Observable<Experiencia>{

    return this.http.post<any>(config.baseUrl + "experiencia/crear", experiencia);

  }

  modificarExperiencia(experiencia : Experiencia) : Observable<any>{

    return this.http.put<any>(config.baseUrl + "experiencia/update", experiencia);

  }

  borarExperiencia(id : number) : Observable<any>{

    return this.http.delete<any>(config.baseUrl + "experiencia/" + id);

  }

  obtnerDatosAcercaDe() : Observable<AcercaDe[]>{

    return this.http.get<any>(config.baseUrl + "acercade");

  }

  guardarNuevaAcercaDe(acercaDe : AcercaDe) : Observable<AcercaDe>{

    return this.http.post<any>(config.baseUrl + "acercade/crear", acercaDe );

  }

  modificarAcercaDe(acercaDe  : AcercaDe ) : Observable<any>{

    return this.http.put<any>(config.baseUrl + "acercade/update", acercaDe );

  }


  obtnerDatosAptitud() : Observable<Aptitud[]>{

    return this.http.get<any>(config.baseUrl + "aptitud");

  }

  guardarNuevaAptitud(aptitud : Aptitud) : Observable<Aptitud>{

    return this.http.post<any>(config.baseUrl + "aptitud/crear", aptitud );

  }

  modificarAptitud(aptitud : Aptitud ) : Observable<any>{

    return this.http.put<any>(config.baseUrl + "aptitud/update", aptitud );

  }

  borarAptitud(id : number) : Observable<any>{

    return this.http.delete<any>(config.baseUrl + "aptitud/" + id);

  }

  obtnerDatosEncabezado() : Observable<Encabezado[]>{

    return this.http.get<any>(config.baseUrl + "encabezado");

  }

  guardarNuevaEncabezado(encabezado : Encabezado) : Observable<Encabezado>{

    return this.http.post<any>(config.baseUrl + "encabezado/crear", encabezado );

  }

  modificarEncabezado(encabezado : Encabezado ) : Observable<any>{

    return this.http.put<any>(config.baseUrl + "encabezado/update", encabezado );

  }

  borarEncabezado(id : number) : Observable<any>{

    return this.http.delete<any>(config.baseUrl + "encabezado/" + id);

  }

  obtnerDatosLogro() : Observable<Logro[]>{

    return this.http.get<any>(config.baseUrl + "logro");

  }

  guardarNuevoLogro(logro : Logro) : Observable<any>{

    return this.http.post<any>(config.baseUrl + "logro/crear", logro );

  }

  modificarLogro(logro : Logro ) : Observable<any>{

    return this.http.put<any>(config.baseUrl + "logro/update", logro );

  }

  borarLogro(id : number) : Observable<any>{

    return this.http.delete<any>(config.baseUrl + "logro/" + id);

  }

  
  obtnerDatosRedes() : Observable<Redes[]>{

    return this.http.get<any>(config.baseUrl + "redes");

  }



}
