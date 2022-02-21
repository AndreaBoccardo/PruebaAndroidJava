package cl.desafiolatm.pruebaandroidjava.service;

import cl.desafiolatm.pruebaandroidjava.modelo.Heroe;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroeService {

    @GET("all.json")
    public Call<Heroe> getHeroe();
}
