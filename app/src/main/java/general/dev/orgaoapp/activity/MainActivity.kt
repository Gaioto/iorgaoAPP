package general.dev.orgaoapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import general.dev.orgaoapp.R
import general.dev.orgaoapp.model.Adress
import general.dev.orgaoapp.network.IorgaoRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

