package info.rafaelferreira.studiodetattoo

import android.text.format.DateFormat
import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.rafaelferreira.studiodetattoo.model.Agendamento
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class ViewHolderAgendamento (var item : View) : RecyclerView.ViewHolder(item) {

    fun bindView(agendamento: Agendamento) {

        val dateFormat = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        val adiant = if (agendamento.teveAdiantamento == true) "Sim" else "Não"

        var txtNome = item.findViewById<TextView>(R.id.txtNome)
        var txtData = item.findViewById<TextView>(R.id.txtData)
        var txtValor = item.findViewById<TextView>(R.id.txtValor)
        var txtAdiantamento = item.findViewById<TextView>(R.id.txtTeveAdiantamento)

        txtNome.text = agendamento.nome
        txtData.text = "Data: " + dateFormat.format(agendamento.data)
        txtValor.text = "Valor: " + agendamento.valor.toString()

        txtAdiantamento.text = "Adiantamento?: " + adiant

    }

}