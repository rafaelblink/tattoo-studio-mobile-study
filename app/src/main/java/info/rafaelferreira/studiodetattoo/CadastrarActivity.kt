package info.rafaelferreira.studiodetattoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.room.Room
import com.google.android.material.button.MaterialButton
import info.rafaelferreira.studiodetattoo.Database.AppDatabase
import info.rafaelferreira.studiodetattoo.model.Agendamento
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

        btnCadastrar.setOnClickListener{

            Thread {
                val localDateTime = LocalDateTime.now()
                val date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
                db.agendamentoDAO().insert(Agendamento(null, "Rafael Ferreira", date, 1000.0, true))
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
