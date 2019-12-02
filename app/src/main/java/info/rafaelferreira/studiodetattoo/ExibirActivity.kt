package info.rafaelferreira.studiodetattoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import info.rafaelferreira.studiodetattoo.model.Agendamento

class ExibirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        var agendamento = intent.getIntExtra("id", 0)

        Toast.makeText(ExibirActivity@this, agendamento.toString(), Toast.LENGTH_LONG).show()
    }
}