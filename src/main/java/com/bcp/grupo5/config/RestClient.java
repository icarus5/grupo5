package com.bcp.grupo5.config;

import com.bcp.grupo5.service.ICreditoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

/*****************************************************************************************
 * Resumen.
 * Objeto                       : Rest.
 * Descripción                  : Clase de implementacion
 * Fecha de Creación            : 29/04/2022
 * Autor                        : Developer02 - NewGenesis .
 * --------------------------------------------------------------------------------------------- 
 * Modificaciones
 * Motivo              Fecha               Nombre                   Descripción
 * --------------------------------------------------------------------------------------------- 
 * [PR][SA][PE]00X    29/04/2022           Developer02 - NewGenesis .      Creacion de la clase.
 ***************************************************************************************/

@Configuration
@Slf4j
@ComponentScan(basePackages = {"com.bcp.grupo5.service"})
public class RestClient {

    public RestClient() {
        System.out.printf("inicio de configuracion");
    }

    private static Retrofit retrofit = null;


    static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://61ef3e91d593d20017dbb3d2.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    @Bean
    public ICreditoService creditoService(){
        return getClient().create(ICreditoService.class);
    }


//    // Create a Bean for svcInvestmentClient and add it to SpringContext.
//    @Bean
//    public ICreditoService createSvcInvestment(String baseUrl, String connectionTimeout, String readTimeout) {
//        return createHttpClient(baseUrl,connectionTimeout, readTimeout,objectMapper).create(SvcInvestment.class);
//    }
//    // Create Retrofit instance of svcInvestment
//    private Retrofit createHttpClient(String baseUrl, String connectionTimeout, String readTimeout, ObjectMapper objectMapper) {
//        OkHttpClient okHttpClient = new OkHttpClientBuilder().
//                connectTimeout(Integer.parseInt(connectionTimeout), TimeUnit.MILLISECONDS),
//        readTimeout(Integer.parseInt(readTimeout), TimeUnit.MILLISECONDS).build();
//        return new Retrofit.Builder().baseUrl(baseUrl).client(okkHttpClient).addConverterFactory(JacksonConverterFactory.create(objectMapper)).build();
//    }

}
