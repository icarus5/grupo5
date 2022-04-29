package com.bcp.grupo5.service;

import com.bcp.grupo5.model.Credito;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

/*****************************************************************************************
 * Resumen.
 * Objeto                       : ICreditoService.
 * Descripción                  : Clase de implementacion
 * Fecha de Creación            : 29/04/2022
 * Autor                        : Developer02 - NewGenesis .
 * --------------------------------------------------------------------------------------------- 
 * Modificaciones
 * Motivo              Fecha               Nombre                   Descripción
 * --------------------------------------------------------------------------------------------- 
 * [PR][SA][PE]00X    29/04/2022           Developer02 - NewGenesis .      Creacion de la clase.
 ***************************************************************************************/


public interface ICreditoService {
    @POST("/test/sunatPayment")
    Mono<Credito> create(Credito credito);

    @GET("/listar")
    Mono<Credito> update(Credito credito);

    @GET("/listar")
    Flux<Credito> listAll();

    @GET("credito/2")
    Call<Credito> listForId();

    @POST("/test/sunatPayment")
    Mono<Void> delete(String id);

}
