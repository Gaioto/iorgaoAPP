package general.dev.orgaoapp.network.service

import general.dev.orgaoapp.model.Donator
import retrofit2.Call
import retrofit2.http.*

interface DonatorService {

    @GET("TbDonators/GetTbDonatorLogin/{email}/{password}")
    fun getDonatorLogin(@Path("email") email: String, @Path("password") password: String ) : Call<Donator>

    @GET("TbDonators/GetTbDonator/{id}")
    fun getDonator(@Path("id") id: Int) : Call<Donator>

    @POST("TbDonators")
    fun postDonator(@Body donator: Donator) : Call<Void>

    @PUT("TbDonators/PutTbDonatorAdress/{id}/{idAdress}")
    fun putDonatorAdress(@Path("id") id: Int, @Path("idAdress") idAdress: Int?) : Call<Donator>
}