package info.rafaelferreira.studiodetattoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.button.MaterialButton
import info.rafaelferreira.studiodetattoo.Database.AppDatabase
import info.rafaelferreira.studiodetattoo.model.Agendamento
import kotlinx.android.synthetic.main.activity_exibir.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class CadastrarActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val btnCadastrar: MaterialButton = findViewById(R.id.btnAtualizar)
        val txtNome: EditText = findViewById(R.id.txtNome)

        val db = returnDB()

        val context = this

        btnCadastrar.setOnClickListener{

            Thread {
                val localDateTime = LocalDateTime.now()
                val date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
                val agendamento = Agendamento(null,null,null,null,null)
                agendamento.nome = txtNome.text.toString()
                agendamento.valor = txtValor?.text.toString().toDouble()
                agendamento.teveAdiantamento = swPagamento.isChecked
                agendamento.data = date
                db.agendamentoDAO().insert(agendamento)
                runOnUiThread {
                    Toast.makeText(CadastrarActivity@this, "Agendamento cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                    finish()
                }
            }.start()
        }

    }

    fun returnDB(): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}
