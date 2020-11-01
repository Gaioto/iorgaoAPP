package general.dev.orgaoapp.network.service

import general.dev.orgaoapp.model.Adress
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AdressService {

    @GET("TbAdresses")
    fun getAdress() : Call<List<Adress>>

    @GET("TbAdresses/{id}")
    fun getAdressesDetails(@Path("id") id: Int) : Call<Adress>

    @GET("TbAdresses/TbAdressesByNumber/{number}")
    fun getAdressesByNumber(@Path("number")number : Int) : Call<Adress>

    @POST("TbAdresses")
    fun postAdress(@Body adress: Adress) : Call<Adress>
}
