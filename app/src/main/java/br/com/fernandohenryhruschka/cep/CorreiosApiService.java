package br.com.fernandohenryhruschka.cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 15/09/2017.
 */

public interface CorreiosApiService {
    @GET("/cep/{cep}")
    Call<CEP> buscarCEP(
            @Path(value = "cep")String cep);
}
