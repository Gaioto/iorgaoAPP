package general.dev.orgaoapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R
import general.dev.orgaoapp.model.Adress
import general.dev.orgaoapp.model.Donator
import general.dev.orgaoapp.network.IorgaoRetrofit
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val intentEndereco = Intent (this, CadastroAdressActivity::class.java)
        val intentLogin = Intent (this, LoginActivity::class.java)

        val patientId: Int = intent.getIntExtra("patient", 0)
        val donatorId: Int = intent.getIntExtra("donator", 0)

        var userLogin = findViewById<TextView>(R.id.nomeUsuario)
        var userId = findViewById<TextView>(R.id.idUser)
        var endButton = findViewById<Button>(R.id.enderecoCadastro)
        var tipoSang = findViewById<TextView>(R.id.tipoSangue)
        var email = findViewById<TextView>(R.id.email)
        var cepUser = findViewById<TextView>(R.id.cep)
        val deslogar = findViewById<Button>(R.id.deslogar)

        var id = 0
        var nome = ""
        var idAdress = 0
        var sang = ""
        var mail = ""
        var cep = ""

        val call = IorgaoRetrofit().donatorService().getDonator(donatorId)
        call.enqueue(object : Callback<Donator> {
            override fun onFailure(call: Call<Donator>, t: Throwable) {
                Toast.makeText(this@UserActivity, "Não foi possivel retornar os dados", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Donator>, response: Response<Donator>) {
                if (response.code().equals(500)) {
                    Toast.makeText(this@UserActivity, "Erro na conexão com o banco de dados", Toast.LENGTH_SHORT).show()
                }
                if (response.code().equals(404)) {
                    Toast.makeText(this@UserActivity, "Não foi possivel encontrar o usuario", Toast.LENGTH_SHORT).show()
                }
                if (response.code().equals(200)) {
                    Toast.makeText(this@UserActivity, "Logado", Toast.LENGTH_SHORT).show()
                    id = response.body()?.idDonator!!
                    nome = response.body()?.nameDonator.toString()
                    sang = response.body()?.bloodTypeDonator.toString()
                    mail = response.body()?.emailDonator.toString()
                    if(response.body()?.idAdress == null){
                        idAdress = 0
                    }else{
                        idAdress = response.body()?.idAdress!!
                    }
                    userId.setText(id.toString())
                    userLogin.setText(nome)
                    tipoSang.setText(sang)
                    email.setText(mail)

                    val callAdress = IorgaoRetrofit().adressService().getAdressesDetails(idAdress)
                    callAdress.enqueue(object : Callback<Adress> {
                        override fun onFailure(call: Call<Adress>, t: Throwable) {
                            Toast.makeText(this@UserActivity, "Não foi possivel retornar os dados", Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<Adress>, response: Response<Adress>) {
                            if (response.code().equals(500)) {
                                Toast.makeText(this@UserActivity, "Erro na conexão com o banco de dados", Toast.LENGTH_SHORT).show()
                            }
                            if (response.code().equals(404)) {
                                Toast.makeText(this@UserActivity, "Não foi possivel encontrar o endereço", Toast.LENGTH_SHORT).show()
                            }
                            if (response.code().equals(200)) {
                                Toast.makeText(this@UserActivity, "Logado", Toast.LENGTH_SHORT).show()
                                cep = response.body()?.zipcodeAdress.toString()
                                if (cep == null || cep == ""){
                                    cepUser.setText("CEP não cadastrado")
                                } else {
                                    cepUser.setText(cep)
                                }
                            }
                        }

                    })

                }
            }
        })

        endButton.setOnClickListener {
            intentEndereco.putExtra("donatorId", id)
            startActivity(intentEndereco)
        }

        deslogar.setOnClickListener {
            startActivity(intentLogin)
        }

    }
}
