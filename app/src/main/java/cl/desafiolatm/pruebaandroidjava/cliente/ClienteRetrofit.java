package cl.desafiolatm.pruebaandroidjava.cliente;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {

    private static Retrofit instance;

    private ClienteRetrofit(){}

    public static String URL_BASE = "https://akabab.github.io/superhero-api/api/";

    public static Retrofit getInstance(String url){
        if(instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
