/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.service;

import com.porfolio.model.Encabezado;
import java.util.List;


public interface IEncabezadoService {
    public List<Encabezado> obtenerEncabezado();
    public Encabezado crearEncabezado(Encabezado encabezado);
    public void borrarEncabezado(Long id);
    public Encabezado obtenerEncabezado(Long id);
    public void modificarEncabezado(Encabezado encabezado);
}
