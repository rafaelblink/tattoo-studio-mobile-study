package info.rafaelferreira.studiodetattoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import info.rafaelferreira.studiodetattoo.Database.AppDatabase
import info.rafaelferreira.studiodetattoo.model.Agendamento
import kotlinx.android.synthetic.main.activity_exibir.*

class ExibirActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        val txtNome: EditText = findViewById(R.id.txtNome)

        var agendamentoID = intent.getIntExtra("id", 0)

        val db = returnDB()

        Thread {
            var agendamento = db.agendamentoDAO().findById(agendamentoID)
            txtNome.setText(agendamento.nome)
        }.start()

        btnExcluir.setOnClickListener {
            Thread {
                val agendamentoDB = db.agendamentoDAO().findById(agendamentoID)
                db.agendamentoDAO().delete(agendamentoDB)
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