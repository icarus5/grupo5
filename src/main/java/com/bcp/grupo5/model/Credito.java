package com.bcp.grupo5.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/*****************************************************************************************
 * Resumen.
 * Objeto                       : Credito.
 * Descripción                  : Clase de implementacion
 * Fecha de Creación            : 29/04/2022
 * Autor                        : Developer02 - NewGenesis .
 * --------------------------------------------------------------------------------------------- 
 * Modificaciones
 * Motivo              Fecha               Nombre                   Descripción
 * --------------------------------------------------------------------------------------------- 
 * [PR][SA][PE]00X    29/04/2022           Developer02 - NewGenesis .      Creacion de la clase.
 ***************************************************************************************/

@Getter
@Setter
public class Credito implements Serializable {

    private String dni;
    private String montoSolicitar;
    private String tipoCredito;
    private String mesesPagar;
    private String moneda;
    private String names;
    private String surnames;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private long id;
    private String formid;

}
