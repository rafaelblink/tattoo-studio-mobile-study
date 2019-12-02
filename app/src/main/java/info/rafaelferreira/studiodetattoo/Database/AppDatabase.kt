package info.rafaelferreira.studiodetattoo.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import info.rafaelferreira.studiodetattoo.Converters
import info.rafaelferreira.studiodetattoo.DAL.AgendamentoDAO
import info.rafaelferreira.studiodetattoo.DAL.UserDAO
import info.rafaelferreira.studiodetattoo.model.Agendamento
import info.rafaelferreira.studiodetattoo.model.User

@Database(entities = arrayOf(User::class, Agendamento::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun agendamentoDAO(): AgendamentoDAO
}