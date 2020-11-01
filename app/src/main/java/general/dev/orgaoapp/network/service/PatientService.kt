package general.dev.orgaoapp.network.service

import general.dev.orgaoapp.model.Donator
import general.dev.orgaoapp.model.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PatientService {

    @GET("TbPatients/GetTbPatientLogin/{email}/{password}")
    fun getPatientLogin(@Path("email") email: String, @Path("password") password: String ) : Call<Patient>

    @GET("TbPatients")
    fun postPatient(@Body patient: Patient) : Call<Void>



}