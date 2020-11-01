//package general.dev.orgaoapp.repository
//
//import android.widget.Toast
//import general.dev.orgaoapp.model.Donator
//import general.dev.orgaoapp.model.Patient
//import general.dev.orgaoapp.network.IorgaoRetrofit
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//interface CallsRepository {
//    fun cadastrarDonator(donator: Donator) {
//        val call = IorgaoRetrofit().donatorService().postDonator(donator)
//
//        call.enqueue(object : Callback<Void> {
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                Toast.makeText(this, "Não foi possível se cadastrar", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                Toast.makeText(this, "O usúario foi cadastrado", Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//
//    fun cadastrarPatient(patient: Patient) {
//        val call = IorgaoRetrofit().patientService().postPatient(patient)
//
//        call.enqueue(object : Callback<Void> {
//            override fun onFailure(call: Call<Void>, t: Throwable) {
//                Toast.makeText(this, "Não foi possível se cadastrar", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                Toast.makeText(this, "O usúario foi cadastrado", Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//}