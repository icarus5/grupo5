package com.bcp.grupo5.service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*****************************************************************************************
 * Resumen.
 * Objeto                       : IServiceBase.
 * Descripción                  : Clase de implementacion
 * Fecha de Creación            : 29/04/2022
 * Autor                        : Developer02 - NewGenesis .
 * --------------------------------------------------------------------------------------------- 
 * Modificaciones
 * Motivo              Fecha               Nombre                   Descripción
 * --------------------------------------------------------------------------------------------- 
 * [PR][SA][PE]00X    29/04/2022           Developer02 - NewGenesis .      Creacion de la clase.
 ***************************************************************************************/

public interface IServiceBase<T, ID> {

    Mono<T> create(T t);

    Mono<T> update(T t);

    Flux<T> listAll();

    Mono<T> listForId(ID id);

    Mono<Void> delete(ID id);

}
