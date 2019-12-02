package info.rafaelferreira.studiodetattoo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import info.rafaelferreira.studiodetattoo.model.Agendamento

class AdapterAgendamento (val context: Context, var listAgendamento : ArrayList<Agendamento>) : RecyclerView.Adapter<ViewHolderAgendamento>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAgendamento {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_agendamento, parent, false);
        return ViewHolderAgendamento(itemView)
    }

    override fun getItemCount(): Int {
        return listAgendamento.size
    }

    override fun onBindViewHolder(holder: ViewHolderAgendamento, position: Int) {
        var agendamento = listAgendamento[position]
        holder.bindView(agendamento)

       holder.item.setOnClickListener{
           val intent = Intent(context, ExibirActivity::class.java)

           intent.putExtra("id", agendamento.id)
           context.startActivity(intent)

       }

    }
}