package general.dev.orgaoapp.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R

class CadastroOrgaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orgao_cadastro)

        val spinnerOrgaos = findViewById<Spinner>(R.id.spinnerOrgao)

        ArrayAdapter.createFromResource(
                this,
                R.array.lista_orgao,
                android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerOrgaos.adapter = adapter
        }
        var sangue: String = spinnerOrgaos.selectedItem.toString()
    }

}