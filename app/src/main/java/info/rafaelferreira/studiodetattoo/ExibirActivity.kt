package info.rafaelferreira.studiodetattoo

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import info.rafaelferreira.studiodetattoo.Database.AppDatabase
import kotlinx.android.synthetic.main.activity_exibir.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


class ExibirActivity : AppCompatActivity() {

    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        val txtNome: EditText = findViewById(R.id.txtNome)

        var agendamentoID = intent.getIntExtra("id", 0)

        val db = returnDB()

        Thread {
            var agendamento = db.agendamentoDAO().findById(agendamentoID)
            txtNome.setText(agendamento.nome)
            txtData.setText(agendamento.data.toString())
            txtValor.setText(agendamento.valor.toString())

            runOnUiThread {
                if(agendamento.teveAdiantamento == true) swPagamento.setChecked(true) else swPagamento.setChecked(false)
            }

        }.start()

        btnExcluir.setOnClickListener {
            Thread {
                val agendamentoDB = db.agendamentoDAO().findById(agendamentoID)
                db.agendamentoDAO().delete(agendamentoDB)
            }.start()
        }

        btnAtualizar.setOnClickListener {
            Thread {
                val agendamentoDB = db.agendamentoDAO().findById(agendamentoID)
                agendamentoDB.nome = txtNome.text.toString()
                val localDateTime = LocalDateTime.now()
                val date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
                agendamentoDB.data = date
                agendamentoDB.valor = java.lang.Double.parseDouble(txtValor.text.toString())
                agendamentoDB.teveAdiantamento = swPagamento.isChecked

                db.agendamentoDAO().update(agendamentoDB)
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