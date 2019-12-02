package info.rafaelferreira.studiodetattoo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.rafaelferreira.studiodetattoo.model.Agendamento

class ViewHolderAgendamento (var item : View) : RecyclerView.ViewHolder(item) {

    fun bindView(agendamento: Agendamento) {
        var txtNome = item.findViewById<TextView>(R.id.txtNome)
        var txtData = item.findViewById<TextView>(R.id.txtData)
        var txtValor = item.findViewById<TextView>(R.id.txtValor)
        var txtAdiantamento = item.findViewById<TextView>(R.id.txtTeveAdiantamento)

        txtNome.text = agendamento.nome
        txtData.text = agendamento.data.toString()
        txtValor.text = agendamento.valor.toString()
        txtAdiantamento.text = agendamento.teveAdiantamento.toString()

    }

}