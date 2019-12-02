package info.rafaelferreira.studiodetattoo.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "agendamentos")
data class Agendamento (

    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "nome") var nome: String?,

    @ColumnInfo(name = "data") var data: Date?,

    @ColumnInfo(name = "valor") var valor: Double?,

    @ColumnInfo(name = "teveAdiantamento") var teveAdiantamento: Boolean?
)
