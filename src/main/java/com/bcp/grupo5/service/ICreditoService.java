package com.bcp.grupo5.service;

import com.bcp.grupo5.model.Credito;
import io.reactivex.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

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
    @POST("/test/")
    Single<Credito> create(Credito credito);

    @GET("/listar")
    Single<Credito> update(Credito credito);

    @GET("credito")
    Flowable<List<Credito>> listAll();

//    @GET("credito")
//    Flowable<Credito> listAll();

    @GET("credito/{id}")
    Maybe<Credito> listForId(@Path("id") String id);

    @POST("/test/")
    Completable delete(String id);

}
