package general.dev.orgaoapp.network

import general.dev.orgaoapp.network.service.AdressService
import general.dev.orgaoapp.network.service.DonatorService
import general.dev.orgaoapp.network.service.PatientService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class IorgaoRetrofit {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://iorgao.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun adressService(): AdressService = retrofit.create(AdressService::class.java)

    fun donatorService(): DonatorService = retrofit.create(DonatorService::class.java)

    fun patientService(): PatientService = retrofit.create((PatientService::class.java))
}