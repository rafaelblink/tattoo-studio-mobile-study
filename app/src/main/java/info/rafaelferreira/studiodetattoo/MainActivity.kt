package info.rafaelferreira.studiodetattoo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import info.rafaelferreira.studiodetattoo.Database.AppDatabase
import info.rafaelferreira.studiodetattoo.model.Agendamento
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var recycleViewAgendamentos : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        recycleViewAgendamentos = findViewById(R.id.recyclerView)
        val fab: View = findViewById(R.id.floatActionButton)

        var listAgendamentos = ArrayList<Agendamento>()
//
//        val localDateTime = LocalDateTime.now()
//
//        val date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())

        Thread {
            val list = db.agendamentoDAO().getAll()
            listAgendamentos = ArrayList(list)

            val adapter = AdapterAgendamento(this, listAgendamentos)

            recycleViewAgendamentos.adapter = adapter
            recycleViewAgendamentos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        }.start()

        fab.setOnClickListener{
            val intent = Intent(MainActivity@this, Cadastrar::class.java)
            startActivity(intent)
        }

//        listAgendamentos.add(Agendamento(1, "Rafael", date, 1000.0, true))
//        listAgendamentos.add(Agendamento(2, "Lucas", date, 1000.0, true))





//        var txtName: TextView = findViewById(R.id.txtName)
//        var texto = ""


//        Thread {
////            var user = User()
////            user.uid = 1
////            user.firstName = "Rafael"
////            user.lastName = "Ferreira"
////
////            db.userDao().insert(user)
//
//
//            db.userDao().getAll().forEach {
//
//                Log.i("PENIS", it.firstName)
//
////                texto = it.firstName
////                txtName.text = texto
//
//            }
//        }.start()




    }
}
