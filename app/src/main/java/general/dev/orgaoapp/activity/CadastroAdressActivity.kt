package general.dev.orgaoapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R
import general.dev.orgaoapp.model.Adress
import general.dev.orgaoapp.model.Donator
import general.dev.orgaoapp.network.IorgaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroAdressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adress_cadastro)

        val cadastroEnd = findViewById<Button>(R.id.cadastroEndereco)
        val intentUser = Intent (this, UserActivity::class.java)

        var idDon : Int = intent.getIntExtra("donatorId",0 )

        fun cadastrarAdress(adress: Adress) {
            val call = IorgaoRetrofit().adressService().postAdress(adress)

            call.enqueue(object : Callback<Adress> {
                override fun onFailure(call: Call<Adress>, t: Throwable) {
                    Toast.makeText(this@CadastroAdressActivity, "Não foi possível se cadastrar", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Adress>, response: Response<Adress>) {
                    if (response.code().equals(500)) {
                        Toast.makeText(this@CadastroAdressActivity, "Não foi possível se conectar ao banco de dados", Toast.LENGTH_LONG).show()
                    }
                    if (response.code().equals(404)) {
                        Toast.makeText(this@CadastroAdressActivity, "Não foi possível se cadastrar no momento", Toast.LENGTH_LONG).show()
                    }
                    if (response.code().equals(200)) {
                        Toast.makeText(this@CadastroAdressActivity, "Endereço cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    }
                }

            })
        }

        cadastroEnd.setOnClickListener {

            val street = findViewById<EditText>(R.id.ruaAdress).text.toString()
            val number = findViewById<EditText>(R.id.numAdress).text.toString().toInt()
            val complement = findViewById<EditText>(R.id.complementAdress).text.toString()
            val city = findViewById<EditText>(R.id.cityAdress).text.toString()
            val zipcode = findViewById<EditText>(R.id.zipcodeAdress).text.toString()
            val state = findViewById<EditText>(R.id.stateAdress).text.toString()

            val adress = Adress(street, number, complement, city, zipcode, state)

            cadastrarAdress(adress)

            val call = IorgaoRetrofit().adressService().getAdressesByNumber(number)

            call.enqueue(object : Callback<Adress> {
                override fun onFailure(call: Call<Adress>, t: Throwable) {
                    Toast.makeText(this@CadastroAdressActivity, "Não foi possível encontrar o endereço", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Adress>, response: Response<Adress>) {
                    if (response.code().equals(500)) {
                        Toast.makeText(this@CadastroAdressActivity, "Não foi possível se conectar ao banco de dados", Toast.LENGTH_LONG).show()
                    }
                    if (response.code().equals(404)) {
                        Toast.makeText(this@CadastroAdressActivity, "Não foi possível se cadastrar no momento", Toast.LENGTH_LONG).show()
                    }
                    if (response.code().equals(200)) {
                        Toast.makeText(this@CadastroAdressActivity, "Endereço cadastrado com sucesso", Toast.LENGTH_LONG).show()
                        var idAdress =  response.body()?.idAdress

                        val call = IorgaoRetrofit().donatorService().putDonatorAdress(idDon, idAdress)

                        call.enqueue(object : Callback<Donator> {
                            override fun onFailure(call: Call<Donator>, t: Throwable) {
                                Toast.makeText(this@CadastroAdressActivity, "Não foi possível atualizar o endereço", Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Donator>, response: Response<Donator>) {
                                if (response.code().equals(500)) {
                                    Toast.makeText(this@CadastroAdressActivity, "Não foi possível se conectar ao banco de dados", Toast.LENGTH_LONG).show()
                                }
                                if (response.code().equals(404)) {
                                    Toast.makeText(this@CadastroAdressActivity, "Não foi possível se cadastrar no momento", Toast.LENGTH_LONG).show()
                                }
                                if (response.code().equals(200)) {
                                    Toast.makeText(this@CadastroAdressActivity, "Endereço cadastrado com sucesso", Toast.LENGTH_LONG).show()
                                }
                            }
                        })
                    }
                }
            })

            intentUser.putExtra("donator", idDon)
            startActivity(intentUser)
        }

    }

}