package com.bcp.grupo5.controller;

import com.bcp.grupo5.model.Credito;
import com.bcp.grupo5.service.ICreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;

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
    public Mono<ResponseEntity<Credito>> registrar(@RequestBody Credito credito, final ServerHttpRequest req) {
        return service.create(credito)
                .map(pl -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(pl.getDni())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(pl)
                );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Credito>> listForId(@PathVariable("id") String id) {
        var monoResponse = Mono.just(service.listForId())
                .map(credito -> {
                    try {
                        return ResponseEntity.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(credito.execute().body());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        return monoResponse;
    }


}
