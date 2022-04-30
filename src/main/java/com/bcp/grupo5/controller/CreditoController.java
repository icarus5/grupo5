package com.bcp.grupo5.controller;

import com.bcp.grupo5.model.Credito;
import com.bcp.grupo5.service.ICreditoService;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/*****************************************************************************************
 * Resumen.
 * Objeto                       : CreditoController.
 * Descripción                  : Clase de implementacion
 * Fecha de Creación            : 29/04/2022
 * Autor                        : Developer02 - NewGenesis .
 * --------------------------------------------------------------------------------------------- 
 * Modificaciones
 * Motivo              Fecha               Nombre                   Descripción
 * --------------------------------------------------------------------------------------------- 
 * [PR][SA][PE]00X    29/04/2022           Developer02 - NewGenesis .      Creacion de la clase.
 ***************************************************************************************/


@RestController
@RequestMapping("/credito")
public class CreditoController {


    @Autowired
    private ICreditoService service;


    @PostMapping
    public Single<ResponseEntity<Credito>> registrar(@RequestBody Credito credito, final ServerHttpRequest req) {
        return service.create(credito)
                .map(pl -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(pl.getDni())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(pl)
                );
    }

    @GetMapping("/{id}")
    public Maybe<ResponseEntity<Credito>> listForId(@PathVariable("id") String id) {

        System.out.printf(id);
//        var monoResponse = Mono.just(service.listForId())
//                .map(credito -> {
//                    try {
//                        return ResponseEntity.ok()
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .body(credito.execute().body());
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//        return monoResponse;
        var credito = service.listForId(id).map(mc -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(mc));
        return credito;

    }

    @GetMapping()
    public Single<ResponseEntity<List<Credito>>> listAll() {
        var responseEntitySingle = Single.fromPublisher(service.listAll()).map(mc -> {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(mc);
        });
        return responseEntitySingle;
//        var lista = service.listAll()
//                .map(mc -> ResponseEntity.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mc)).firstElement();
//        return lista;

    }


}
