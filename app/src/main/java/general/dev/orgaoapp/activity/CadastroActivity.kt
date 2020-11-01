package general.dev.orgaoapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R
import general.dev.orgaoapp.model.Donator
import general.dev.orgaoapp.model.Patient
import general.dev.orgaoapp.network.IorgaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val intentLogin = Intent(this, LoginActivity::class.java)

        var spinnerTypeUser = findViewById<Spinner>(R.id.typeUser)
        val spinnerSangue = findViewById<Spinner>(R.id.tipoSangueUser)
        val spinnerGenre = findViewById<Spinner>(R.id.generoUser)
        val cadastrar = findViewById<Button>(R.id.cadastrar)

        ArrayAdapter.createFromResource(
                this,
                R.array.lista_sangue,
                android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerSangue.adapter = adapter
        }
        var sangue: String = spinnerSangue.selectedItem.toString()

        ArrayAdapter.createFromResource(
                this,
                R.array.lista_genero,
                android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerGenre.adapter = adapter
        }
        var genero: String = spinnerGenre.selectedItem.toString()

        ArrayAdapter.createFromResource(
                this,
                R.array.lista_user,
                android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerTypeUser.adapter = adapter
        }
        var tipoUsuario: String = spinnerTypeUser.selectedItem.toString()

        fun cadastrarDonator(donator: Donator) {
            val call = IorgaoRetrofit().donatorService().postDonator(donator)

            call.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@CadastroActivity, "Não foi possível se cadastrar", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(this@CadastroActivity, "O usúario foi cadastrado", Toast.LENGTH_LONG).show()
                }
            })
        }

        fun cadastrarPatient(patient: Patient) {
            val call = IorgaoRetrofit().patientService().postPatient(patient)

            call.enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@CadastroActivity, "Não foi possível se cadastrar", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(this@CadastroActivity, "O usúario foi cadastrado", Toast.LENGTH_LONG).show()
                }
            })
        }

        cadastrar.setOnClickListener {

            var nomeUser =  findViewById<EditText>(R.id.username).text.toString()
            var rgUser = findViewById<EditText>(R.id.rgUser).text.toString()
            var cpfUser = findViewById<EditText>(R.id.cpfUser).text.toString()
            var telUser = findViewById<EditText>(R.id.telUser).text.toString()
            var emailUser = findViewById<EditText>(R.id.emailUser).text.toString()
            var senhaUser = findViewById<EditText>(R.id.senhaUser).text.toString()
            var pesoUser = findViewById<EditText>(R.id.pesoUser).text.toString().toDouble()
            var alturaUser = findViewById<EditText>(R.id.alturaUser).text.toString().toDouble()

            if(tipoUsuario.equals("Paciente")){
                val userPat = Patient(nomeUser, rgUser, cpfUser, telUser, emailUser, senhaUser, genero, "2020-10-31T17:15:26.078Z", alturaUser, pesoUser, sangue)
                cadastrarPatient(userPat)
            } else {
                val userDon = Donator(nomeUser, rgUser, cpfUser, telUser, emailUser, senhaUser, genero, "2020-10-31T17:15:26.078Z", alturaUser, pesoUser, sangue)
                cadastrarDonator(userDon)
            }
            startActivity(intentLogin)
        }
    }
}

