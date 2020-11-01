package general.dev.orgaoapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R
import general.dev.orgaoapp.model.Adress
import general.dev.orgaoapp.model.Donator
import general.dev.orgaoapp.model.Patient
import general.dev.orgaoapp.network.IorgaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login = findViewById<Button>(R.id.login)
        val cadastrar = findViewById<Button>(R.id.cadastro)
        val intentCadastro = Intent (this, CadastroActivity::class.java)
        val intentUser = Intent (this, UserActivity::class.java)

        login.setOnClickListener {
            var username =  findViewById<EditText>(R.id.username).text.toString()
            var password = findViewById<EditText>(R.id.password).text.toString()
            val loginDonator = IorgaoRetrofit().donatorService().getDonatorLogin(username, password)
            val loginPatient = IorgaoRetrofit().patientService().getPatientLogin(username, password)

            loginDonator.enqueue(object : Callback<Donator> {
                override fun onFailure(loginDonator: Call<Donator>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Não foi possivel logar no momento", Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(loginDonator: Call<Donator>, response: Response<Donator>) {
                    if(response.code().equals(404)){
                        loginPatient.enqueue(object : Callback<Patient> {
                            override fun onFailure(call: Call<Patient>, t: Throwable) {
                                Toast.makeText(this@LoginActivity, "Não foi possivel logar no momento", Toast.LENGTH_SHORT).show()
                            }

                            override fun onResponse(call: Call<Patient>, response: Response<Patient>) {
                                if(response.code().equals(404)){
                                    Toast.makeText(this@LoginActivity, "Por favor confira os campos digitados", Toast.LENGTH_SHORT).show()
                                }
                                if(response.code().equals(200)){
                                    Toast.makeText(this@LoginActivity, "Logando...", Toast.LENGTH_SHORT).show()
                                    var patient = response.body()?.idPatient
                                    intentUser.putExtra("patient", patient)
                                    startActivity(intentUser)
                                }
                                if(response.code().equals(500)){
                                    Toast.makeText(this@LoginActivity, "Problema na conexão com o banco de dados", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    }
                    if(response.code().equals(200)){
                        Toast.makeText(this@LoginActivity, "Logando...", Toast.LENGTH_SHORT).show()
                        var donator = response.body()?.idDonator
                        intentUser.putExtra("donator", donator)
                        startActivity(intentUser)
                    }
                    if(response.code().equals(500)){
                        Toast.makeText(this@LoginActivity, "Problema na conexão com o banco de dados", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
        cadastrar.setOnClickListener {
            startActivity(intentCadastro)
        }

    }

}
