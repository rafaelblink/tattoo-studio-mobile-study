package info.rafaelferreira.studiodetattoo.DAL

import androidx.room.*
import info.rafaelferreira.studiodetattoo.model.Agendamento

@Dao
interface AgendamentoDAO {
    @Query("SELECT * FROM agendamentos")
    fun getAll(): List<Agendamento>

    @Query("SELECT * FROM agendamentos WHERE id LIKE :id")
    fun findById(id: Int): Agendamento

    @Insert
    fun insert(vararg agendamento: Agendamento)

    @Delete
    fun delete(agendamento: Agendamento)

    @Update
    fun update(vararg agendamento: Agendamento)
}